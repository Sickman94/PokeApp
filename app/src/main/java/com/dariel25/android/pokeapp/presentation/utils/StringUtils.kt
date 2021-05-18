package com.dariel25.android.pokeapp.presentation.utils

object StringUtils {
    fun getUrlId(url: String): String {
        val str = url.split("/")
        return str[str.size - 2]
    }

    fun getIdTitle(id: String): String {
        var idTitle = "#"
        val zeros = 3 - id.length
        repeat (zeros) {
            idTitle += "0"
        }
        return idTitle + id
    }
}