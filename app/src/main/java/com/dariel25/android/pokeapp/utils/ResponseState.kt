package com.dariel25.android.pokeapp.utils

sealed class ResponseState<out T> {

    data class Success<out T>(val data: T): ResponseState<T>()
    data class Error<out T>(val message: String): ResponseState<T>()

    companion object {
        fun <T> success(data: T): ResponseState<T> = Success(data)
        fun <T> error(message: String): ResponseState<T> = Error(message)
    }
}
