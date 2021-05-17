package com.dariel25.android.pokeapp.presentation.pokelist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dariel25.android.pokeapp.domain.model.PokemonSimple
import com.dariel25.android.pokeapp.domain.pokelist.PokemonsUseCase
import com.dariel25.android.pokeapp.utils.ResponseState
import com.dariel25.android.pokeapp.utils.ViewState
import kotlinx.coroutines.launch

class PokeListViewModel(private val pokemonsUseCase: PokemonsUseCase) : ViewModel() {

    private val mutableViewState = MutableLiveData<ViewState<List<PokemonSimple>?>>()

    init {
        fetchPokemons()
    }

    fun getViewStateLiveData(): LiveData<ViewState<List<PokemonSimple>?>> {
        return mutableViewState
    }

    fun firstLoad() {

    }

    private fun fetchPokemons() {
        mutableViewState.value = ViewState.loading()

        viewModelScope.launch {
            when (val networkStatus = pokemonsUseCase.getPokemonList()) {
                is ResponseState.Success -> {
                    mutableViewState.value = ViewState.success(networkStatus.data)
                }
                is ResponseState.Error -> mutableViewState.value = ViewState.error(networkStatus.message)
                else -> mutableViewState.value = ViewState.error("unknown error")
            }
        }
    }
}
