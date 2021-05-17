package com.dariel25.android.pokeapp.utils

import android.graphics.Color

object PokemonTypeUtils {

    fun getTypeColor(types: List<String>) : Int {
        for (t in types) {
            when (t) {
                "grass" -> return Color.GREEN
                "fire" -> return Color.RED
                "water" -> return Color.BLUE
                "electric" -> return Color.YELLOW
                "ground" -> return Color.GRAY
                "psychic" -> return Color.GRAY
                "ghost" -> return Color.GRAY
                "rock" -> return Color.GRAY
            }
        }
        for (t in types) {
            when (t) {
                "bug" -> return Color.GREEN
                "poison" -> return Color.GREEN
                "ice" -> return Color.CYAN
            }
        }
        return Color.WHITE
    }


}
