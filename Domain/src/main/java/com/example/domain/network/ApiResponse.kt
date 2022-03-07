package com.example.domain.network

import retrofit2.Response

sealed class ApiResponse<T> {

    object ApiEmptyResponse : ApiResponse<Nothing>()

    class ApiSuccessResponse<T>(val body: T) : ApiResponse<T>()

    class ApiErrorResponse<T>(val error: ApiError) : ApiResponse<T>()


    companion object {
        fun <T> create(error: Throwable): ApiResponse<T> {
            return ApiErrorResponse(ApiError.Unknown(error))
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return when {
                response.code() == 200 -> {
                    when (val body = response.body()) {
                        null -> ApiErrorResponse(ApiError.NoContent)
                        else -> ApiSuccessResponse(body)
                    }
                }
                response.code() == 500 -> ApiErrorResponse(ApiError.Internal)
                else -> ApiErrorResponse(ApiError.BadResponseCode(response.code()))
            }
        }
    }
}
