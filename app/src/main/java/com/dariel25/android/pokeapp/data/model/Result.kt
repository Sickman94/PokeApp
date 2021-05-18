package com.dariel25.android.pokeapp.data.model

sealed class Result<out T> {

    data class Success<out T>(val data: T): Result<T>()
    data class Error<out T>(val error: Throwable): Result<T>()

    companion object {
        fun <T> success(data: T): Result<T> = Success(data)
        fun <T> error(error: Throwable): Result<T> = Error(error)
    }
}
