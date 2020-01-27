package com.architect.coders.mu8.data

import android.app.Application
import androidx.room.Room
import com.architect.coders.mu8.data.database.MU8Database

open class DataApp : Application() {

    lateinit var database: MU8Database
        private set

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            MU8Database::class.java,
            "MU8-db"
        ).fallbackToDestructiveMigration().build()
    }
}