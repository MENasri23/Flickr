package com.example.domain.network

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Resource<out R>(
    val data: R? = null,
    val message: String? = null
) {

    class Success<out T>(data: T) : Resource<T>(data)
    class Loading<out T>(data: T? = null) : Resource<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : Resource<T>(data, throwable.message)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$message]"
            is Loading -> "Loading"
        }
    }
}