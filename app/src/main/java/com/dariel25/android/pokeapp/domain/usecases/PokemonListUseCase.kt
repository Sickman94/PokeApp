package com.dariel25.android.pokeapp.domain.usecases

import com.dariel25.android.pokeapp.data.network.model.Resource
import com.dariel25.android.pokeapp.domain.model.PokemonSimple
import com.dariel25.android.pokeapp.domain.repository.PokemonListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonListUseCase(private val repository: PokemonListRepository) {

    suspend fun getPokemonList() : Resource<List<PokemonSimple>> = try {
        val pokemonList = withContext(Dispatchers.IO) {
            repository.getPokemonList()
        }
        Resource.Success(pokemonList)
    } catch (e: Throwable) {
        Resource.Error(e)
    }
}