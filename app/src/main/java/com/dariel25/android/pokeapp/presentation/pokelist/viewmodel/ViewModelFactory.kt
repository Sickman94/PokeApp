package com.dariel25.android.pokeapp.presentation.pokelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dariel25.android.pokeapp.data.api.ApiClient
import com.dariel25.android.pokeapp.data.repository.PokemonListRepository
import com.dariel25.android.pokeapp.domain.pokelist.PokemonsUseCase

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokeListViewModel::class.java)) {
            return PokeListViewModel(PokemonsUseCase(PokemonListRepository(ApiClient()))) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}