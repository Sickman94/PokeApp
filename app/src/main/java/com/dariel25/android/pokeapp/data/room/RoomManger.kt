package com.dariel25.android.pokeapp.data.room

import android.content.Context
import androidx.room.Room

object RoomManger {

    private var instance: PokeAppDatabase? = null

    fun initRoomDb(context: Context) {
        if (instance == null) {
            instance = Room
                .databaseBuilder(context, PokeAppDatabase::class.java, "pokemonSimple")
                .build()
        }
    }

    fun getInstance(): PokeAppDatabase? = instance

}