package com.dariel25.android.pokeapp.domain.model

data class PokemonSimple(
    val id: String = "",
    val name: String = "",
    val types: ArrayList<String> = arrayListOf()
)