package com.dariel25.android.pokeapp.di

import com.dariel25.android.pokeapp.BuildConfig
import com.dariel25.android.pokeapp.data.network.PokeApi
import com.dariel25.android.pokeapp.data.network.PokeListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val LIST_BASE_URL = "https://raw.githubusercontent.com/Sickman94/PokeApp/main/"
    private const val POKE_API_BASE_URL = "https://pokeapi.co/api/v2/"

    @Provides
    internal fun providesLoggingInterceptor(): HttpLoggingInterceptor? =
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        } else null

    @Provides
    internal fun providesOkHttpClientBuilder(
        loggingInterceptor: HttpLoggingInterceptor?
    ): OkHttpClient.Builder =
        OkHttpClient.Builder().apply {
            loggingInterceptor?.also {
                addInterceptor(it)
            }
        }

    @Provides
    internal fun providesOkHttpClient(
        builder: OkHttpClient.Builder
    ): OkHttpClient = builder
        .build()

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class PokeListRetrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class PokeApiRetrofit

    @PokeListRetrofit
    @Provides
    @Singleton
    internal fun providesPokeListRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(LIST_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @PokeApiRetrofit
    @Provides
    @Singleton
    internal fun providesPokeApiRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(POKE_API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    internal fun providesPokeListApi(
        @PokeListRetrofit retrofit: Retrofit
    ): PokeListApi =
        retrofit.create(PokeListApi::class.java)

    @Provides
    internal fun providesPokeApi(
        @PokeApiRetrofit retrofit: Retrofit
    ): PokeApi =
        retrofit.create(PokeApi::class.java)
}