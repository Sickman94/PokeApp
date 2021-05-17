package com.dariel25.android.pokeapp.data.api

import com.dariel25.android.pokeapp.domain.model.PokemonSimple
import retrofit2.http.GET

interface PokeApiService {

    @GET("pokemon.json")
    suspend fun getPokemonList(): List<PokemonSimple>

}