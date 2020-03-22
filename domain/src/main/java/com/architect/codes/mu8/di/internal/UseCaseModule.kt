package com.architect.codes.mu8.di.internal

import com.architect.codes.mu8.characters.CharactersUseCase
import com.architect.codes.mu8.characters.CharactersUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [UseCaseImplementationsModule::class])
internal abstract class UseCaseModule {

    @Binds
    abstract fun provideCharactersUseCase(impl: CharactersUseCaseImpl): CharactersUseCase
}