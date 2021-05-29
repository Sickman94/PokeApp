package com.dariel25.android.pokeapp.presentation.model

sealed class ViewState<out T> {

    data class Success<out T>(val data: T): ViewState<T>()
    data class Error<out T>(val message: String): ViewState<T>()
    data class Loading<out T>(val value: T? = null): ViewState<T>()
}
