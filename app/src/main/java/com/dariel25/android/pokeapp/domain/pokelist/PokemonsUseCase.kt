package com.dariel25.android.pokeapp.domain.pokelist

import com.dariel25.android.pokeapp.data.repository.PokemonListRepository
import com.dariel25.android.pokeapp.domain.model.PokemonSimple
import com.dariel25.android.pokeapp.utils.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonsUseCase(private val repository: PokemonListRepository) {

    suspend fun getPokemonList() : ResponseState<List<PokemonSimple>> = try {
        val pokemonList = withContext(Dispatchers.IO) {
            repository.getPokemonList()
        }
        ResponseState.Success(pokemonList)
    } catch (e: Throwable) {
        ResponseState.error<Nothing>("Error: " + e.message)
    }
}