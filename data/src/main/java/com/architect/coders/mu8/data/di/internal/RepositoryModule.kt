package com.architect.coders.mu8.data.di.internal

import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import com.architect.codes.mu8.characters.CharactersRepository
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryImplementationsModule::class])
internal abstract class RepositoryModule {

    @Binds
    abstract fun providesCharactersRepository(impl: CharactersRepositoryImpl): CharactersRepository
}