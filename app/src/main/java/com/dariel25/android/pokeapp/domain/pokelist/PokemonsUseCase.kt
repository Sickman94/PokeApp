package com.dariel25.android.pokeapp.domain.pokelist

import com.dariel25.android.pokeapp.data.repository.PokemonListRepository
import com.dariel25.android.pokeapp.domain.model.PokemonSimple
import com.dariel25.android.pokeapp.utils.ResponseState
import com.dariel25.android.pokeapp.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonsUseCase(private val repository: PokemonListRepository) {

    suspend fun getPokemonList() : ResponseState<List<PokemonSimple>> = try {
        val pokemonList = withContext(Dispatchers.IO) {
            val list = arrayListOf<PokemonSimple>()
            val count = repository.getPokemonCount()
            for (p in repository.getPokemonList(count.toString())) {
                val id = Utils.getUrlId(p.url)
                list.add(PokemonSimple(id, p.name))
            }
            list
        }
        ResponseState.Success(pokemonList)
    } catch (e: Throwable) {
        ResponseState.error<Nothing>("Error: " + e.message)
    }

    suspend fun getPokemonListWithTypes() : ResponseState<List<PokemonSimple>> = try {
        val pokemonList = withContext(Dispatchers.IO) {
            val list = arrayListOf<PokemonSimple>()
            val types = repository.getPokemonTypes()
            for (t in types) {
                for (p in getPokemonListByType(Utils.getUrlId(t.url))) {
                    val index = list.indexOfFirst { it.id == p.id }
                    if (index == -1) {
                        list.add(p)
                    } else {
                        list[index].types.add(t.name)
                    }
                }
            }
            list.sortedBy { it.id.toInt() }
        }
        ResponseState.Success(pokemonList)
    } catch (e: Throwable) {
        ResponseState.error<Nothing>("Error: " + e.message)
    }

    private suspend fun getPokemonListByType(typeId: String) : List<PokemonSimple> {
        val pokemonList = arrayListOf<PokemonSimple>()
        val type = repository.getPokemonType(typeId)
        for (p in type.pokemon) {
            val t = arrayListOf<String>()
            t.add(type.name)
            val id = Utils.getUrlId(p.pokemon.url)
            pokemonList.add(PokemonSimple(id, p.pokemon.name, t))
        }
        return pokemonList
    }
}