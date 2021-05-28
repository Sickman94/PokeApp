package com.dariel25.android.pokeapp.data.api

import com.dariel25.android.pokeapp.data.model.PokemonSimple
import retrofit2.http.GET

interface PokeListService {

    @GET("pokemon.json")
    suspend fun getPokemonList(): List<PokemonSimple>

}