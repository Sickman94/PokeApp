package com.dariel25.android.pokeapp.data.repository

import com.dariel25.android.pokeapp.data.api.ApiClient
import com.dariel25.android.pokeapp.data.model.GenericResult
import com.dariel25.android.pokeapp.data.model.PokemonType

class PokemonListRepository(private val apiClient: ApiClient) {

    suspend fun getPokemonList(limit: String): List<GenericResult> =
        apiClient.getPokemonsApi().getPokemonList(limit).results

    suspend fun getPokemonCount(): Int =
        apiClient.getPokemonsApi().getPokemonList().count

    suspend fun getPokemonTypes(): List<GenericResult> =
        apiClient.getPokemonsApi().getPokemonTypes().results

    suspend fun getPokemonType(typeId: String): PokemonType =
        apiClient.getPokemonsApi().getType(typeId)

}
