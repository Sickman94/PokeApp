package com.dariel25.android.pokeapp.presentation.pokelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dariel25.android.pokeapp.data.mapper.PokemonSimpleMapper
import com.dariel25.android.pokeapp.data.network.ApiProvider
import com.dariel25.android.pokeapp.data.repository.PokemonListRepositoryImpl
import com.dariel25.android.pokeapp.data.room.RoomManger
import com.dariel25.android.pokeapp.domain.usecases.PokemonListUseCase

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokeListViewModel::class.java)) {
            return PokeListViewModel(PokemonListUseCase(
                PokemonListRepositoryImpl(
                    ApiProvider.getPokemonListService(),
                    RoomManger.getInstance()?.pokemonSimpleDao(),
                    PokemonSimpleMapper()
                )
            )) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}