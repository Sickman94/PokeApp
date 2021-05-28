package com.dariel25.android.pokeapp.data.api

class ApiClient {

    fun getPokemonListService(): PokeListService {
        return RetrofitBuilder.createRepositoryApi(PokeListService::class.java, LIST_BASE_URL)
    }

    fun getPokeApiService(): PokeApiService {
        return RetrofitBuilder.createRepositoryApi(PokeApiService::class.java, POKE_API_BASE_URL)
    }

    companion object {
        private const val LIST_BASE_URL = "https://raw.githubusercontent.com/Sickman94/PokeApp/main/"
        private const val POKE_API_BASE_URL = "https://pokeapi.co/api/v2/"
    }
}