package com.dariel25.android.pokeapp.data.api

class ApiClient {

    fun getPokemonsApi(): PokeApiService {
        return RetrofitBuilder.createRepositoryApi(PokeApiService::class.java)
    }
}