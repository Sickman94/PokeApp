package com.dariel25.android.pokeapp.presentation.models

sealed class ViewState<out T> {

    data class Success<out T>(val data: T): ViewState<T>()
    data class Error<out T>(val message: String): ViewState<T>()
    data class Loading<out T>(val value: T? = null): ViewState<T>()

    companion object {
        fun <T> success(data: T): ViewState<T> = Success(data)
        fun <T> error(message: String): ViewState<T> = Error(message)
        fun <T> loading(): ViewState<T> = Loading()
    }
}
