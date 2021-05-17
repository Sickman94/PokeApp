package com.dariel25.android.pokeapp.data.model

data class Resource <out T>(
    val count: Int,
    val results: List<T>
)
