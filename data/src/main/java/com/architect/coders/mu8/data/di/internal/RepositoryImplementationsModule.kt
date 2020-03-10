package com.architect.coders.mu8.data.di.internal

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryImplementationsModule {

    @Provides
    fun providesCharactersRepositoryImpl(app: DataApp) = CharactersRepositoryImpl(app)
}