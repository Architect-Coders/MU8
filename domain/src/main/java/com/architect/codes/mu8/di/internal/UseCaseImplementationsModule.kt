package com.architect.codes.mu8.di.internal

import com.architect.codes.mu8.characters.CharactersRepository
import com.architect.codes.mu8.characters.CharactersUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
internal class UseCaseImplementationsModule {

    @Provides
    fun providesCharactersUseCaseImpl(charactersRepository: CharactersRepository) = CharactersUseCaseImpl(charactersRepository)
}