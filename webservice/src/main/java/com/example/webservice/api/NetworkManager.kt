package com.example.webservice.api

import com.example.webservice.util.LiveDataCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager {

    companion object {
        private const val BASE_URL = "https://www.flickr.com/services/"
        private const val API_KEY_PARAM = "api_key"
        private const val API_KEY_VALUE = "1c04e05bce6e626247758d120b372a73"

        private var flickrInstance: FlickrService? = null

        fun createFlickService() = flickrInstance ?: synchronized(this) {
            flickrInstance ?: buildFlickrService().also { flickrInstance = it }
        }

        private fun buildFlickrService(): FlickrService {
            val retrofit = createRetrofit()
            return retrofit
                .create(FlickrService::class.java)
        }

        private fun createRetrofit(): Retrofit {
            val okHttpClient = createOkHttpClient()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
        }

        private fun createOkHttpClient() = OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor())
            .addInterceptor(createHeaderInterceptor())
            .build()

        private fun createLoggingInterceptor() = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private fun createHeaderInterceptor() = Interceptor { chain ->
            val origin = chain.request()
            val newUrl = origin.url.newBuilder()
                .addQueryParameter(API_KEY_PARAM, API_KEY_VALUE)
                .build()

            val newRequest = origin.newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }

    }
}