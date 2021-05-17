package com.dariel25.android.pokeapp.data.api

import com.dariel25.android.pokeapp.data.model.GenericResult
import com.dariel25.android.pokeapp.data.model.PokemonType
import com.dariel25.android.pokeapp.data.model.Resource
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    @GET("pokemon")
    suspend fun getPokemonList()
    : Resource<GenericResult>

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: String
    ): Resource<GenericResult>

    @GET("type")
    suspend fun getPokemonTypes()
    : Resource<GenericResult>

    @GET("type/{id}")
    suspend fun getType(
        @Path("id") typeId: String
    ): PokemonType

}