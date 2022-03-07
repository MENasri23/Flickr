package com.example.webservice.model

sealed class ApiError {

    class Unknown(val throwable: Throwable) : ApiError()

    class BadResponseCode(val responseCode: Int) : ApiError()

    object Parse : ApiError()

    object NoConnection : ApiError()

    object RefreshTokenFailed : ApiError()

    object NoContent : ApiError()

    object Internal : ApiError()

    sealed class HandledError(val error: Error) : ApiError() {
        companion object {
            const val BAD_REQUEST = 400
            const val FORBIDDEN = 403
            const val NOT_FOUND = 404
            const val REQUEST_TIMEOUT = 408
            const val CONFLICT = 409
            const val VERIFY_OTP_FAILED = 1000
        }

        class VerifyOtpFailed(message: String) : HandledError(Error(VERIFY_OTP_FAILED, message))
        class NotFound(message: String) : HandledError(Error(NOT_FOUND, message))
        class Forbidden(message: String) : HandledError(Error(FORBIDDEN, message))
        class BadRequest(message: String) : HandledError(Error(BAD_REQUEST, message))
        class Global(globalError: Error) : HandledError(globalError)
    }

}