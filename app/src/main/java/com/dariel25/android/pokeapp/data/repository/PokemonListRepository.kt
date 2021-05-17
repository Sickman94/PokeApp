package com.dariel25.android.pokeapp.data.repository

import com.dariel25.android.pokeapp.data.api.ApiClient
import com.dariel25.android.pokeapp.domain.model.PokemonSimple

class PokemonListRepository(private val apiClient: ApiClient) {

    suspend fun getPokemonList(): List<PokemonSimple> =
        apiClient.getPokemonsApi().getPokemonList()

}
