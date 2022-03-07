package com.example.webservice.api

import com.example.webservice.util.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager {

    companion object {
        private const val BASE_URL = "https://www.flickr.com/services/"
        private var flickrInstance: FlickrService? = null

        fun createFlickService() = flickrInstance ?: synchronized(this) {
            flickrInstance ?: buildFlickrService()
        }

        private fun buildFlickrService(): FlickrService {
            val okHttpClient = createOkHttpClient()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()

            return retrofit
                .create(FlickrService::class.java)
                .also { flickrInstance = it }
        }

        private fun createOkHttpClient() = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    }
}