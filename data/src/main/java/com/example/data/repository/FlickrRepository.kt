package com.example.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.data.Resource
import com.example.data.source.remote.FlickrQueryParams
import com.example.data.source.remote.RemoteFlickrDataSource
import com.example.data.util.AppExecutors
import com.example.domain.model.PhotoItem
import com.example.webservice.model.ApiError
import com.example.webservice.model.ApiResponse

class FlickrRepository(
    private val remoteDataSource: RemoteFlickrDataSource,
    private val executors: AppExecutors
) {

    private val lock = object {}

    private val cachedPhotos = mutableListOf<PhotoItem>()
    private val result = MediatorLiveData<Resource<List<PhotoItem>>>()

    fun getPhotos(
        queryParams: FlickrQueryParams,
    ): LiveData<Resource<List<PhotoItem>>> {
        result.value = Resource.Loading()
        val apiResponse = remoteDataSource.fetchPhotos(queryParams)

        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)

            when (response) {
                is ApiResponse.ApiSuccessResponse -> {
                    executors.diskIO().execute {
                        val photos = response.body.photoResponse.photos
                        synchronized(lock) {
                            cachedPhotos.addAll(photos)
                        }

                        executors.mainThread().execute {
                            result.value = Resource.Success(cachedPhotos)
                        }
                    }
                }

                is ApiResponse.ApiEmptyResponse -> {
                    result.value = Resource.Success(cachedPhotos)
                }

                is ApiResponse.ApiErrorResponse -> {
                    val apiError = response.error
                    if (apiError is ApiError.Unknown) {
                        result.value = Resource.Error(apiError.throwable)
                    }
                }
            }
        }

        return result.asLiveData()
    }
}

private fun <T> MediatorLiveData<T>.asLiveData() = this as LiveData<T>
