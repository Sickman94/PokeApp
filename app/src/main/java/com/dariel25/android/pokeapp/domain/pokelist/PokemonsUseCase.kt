package com.dariel25.android.pokeapp.domain.pokelist

import com.dariel25.android.pokeapp.data.repository.PokemonListRepository
import com.dariel25.android.pokeapp.domain.model.PokemonSimple
import com.dariel25.android.pokeapp.data.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonsUseCase(private val repository: PokemonListRepository) {

    suspend fun getPokemonList() : Result<List<PokemonSimple>> = try {
        val pokemonList = withContext(Dispatchers.IO) {
            repository.getPokemonList().filter { !it.mega }
        }
        Result.Success(pokemonList)
    } catch (e: Throwable) {
        Result.error(e)
    }
}