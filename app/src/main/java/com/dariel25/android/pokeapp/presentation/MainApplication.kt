package com.dariel25.android.pokeapp.presentation

import android.app.Application
import com.dariel25.android.pokeapp.data.room.RoomManger

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        RoomManger.initRoomDb(this)
    }
}