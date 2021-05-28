package com.dariel25.android.pokeapp.data.api

import com.dariel25.android.pokeapp.data.model.PokemonSimple
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: String
    ): List<PokemonSimple>

}