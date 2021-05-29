package com.dariel25.android.pokeapp.data.network.model

sealed class Resource<out T> {

    data class Success<out T>(val data: T): Resource<T>()
    data class Error<out T>(val error: Throwable): Resource<T>()

}
