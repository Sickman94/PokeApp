package com.dariel25.android.pokeapp.utils

import android.graphics.Color

object ColorUtils {

    fun getColor(color: String) : Int =
            when (color) {
                "Green" -> Color.GREEN
                "Red" -> Color.RED
                "Blue" -> Color.BLUE
                "Black" -> Color.BLACK
                "Yellow" -> Color.YELLOW
                "Purple" -> Color.WHITE
                "Brown" -> Color.WHITE
                "Pink" -> Color.WHITE
                "Grey" -> Color.WHITE
                else -> Color.WHITE
            }
}
