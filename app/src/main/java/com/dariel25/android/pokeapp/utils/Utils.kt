package com.dariel25.android.pokeapp.utils

object Utils {
    fun getUrlId(url: String): String {
        val str = url.split("/")
        return str[str.size - 2]
    }
}