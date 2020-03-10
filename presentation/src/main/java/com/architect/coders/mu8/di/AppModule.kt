package com.architect.coders.mu8.di

import android.app.Application
import androidx.room.Room
import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import com.architect.coders.mu8.data.database.MU8Database
import com.architect.codes.mu8.characters.CharactersRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun databaseProvider(app: DataApp) = app.database
}