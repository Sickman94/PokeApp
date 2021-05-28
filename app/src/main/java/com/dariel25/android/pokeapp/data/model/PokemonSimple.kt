package com.dariel25.android.pokeapp.data.model

data class PokemonSimple(
    val id: String = "",
    val name: String = "",
    val type1: String = "",
    val type2: String = "",
    val color: String = "",
    val legendary: Boolean = false,
    val height: Float = 0F,
    val weight: Float = 0F,
    val hp: Float = 0F,
    val atk: Float = 0F,
    val def: Float = 0F,
    val sp_atk: Float = 0F,
    val sp_def: Float = 0F,
    val spd: Float = 0F,
    val total: Float = 0F
)
