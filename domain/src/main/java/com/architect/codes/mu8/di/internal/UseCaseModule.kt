package com.architect.codes.mu8.di.internal

import com.architect.codes.mu8.characters.CharactersUseCase
import com.architect.codes.mu8.characters.CharactersUseCaseImpl
import com.architect.codes.mu8.characters.detail.CharacterDetailUseCase
import com.architect.codes.mu8.characters.detail.CharacterDetailUseCaseImpl
import com.architect.codes.mu8.comics.ComicUseCase
import com.architect.codes.mu8.comics.ComicsUseCaseImpl
import com.architect.codes.mu8.events.EventsUseCase
import com.architect.codes.mu8.events.EventsUserCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [UseCaseImplementationsModule::class])
internal abstract class UseCaseModule {

    @Binds
    abstract fun provideCharactersUseCase(impl: CharactersUseCaseImpl): CharactersUseCase

    @Binds
    abstract fun provideCharacterDetailUseCase(impl: CharacterDetailUseCaseImpl): CharacterDetailUseCase

    @Binds
    abstract fun provideComicUseCase(impl: ComicsUseCaseImpl): ComicUseCase

    @Binds
    abstract fun provideEventsUseCase(impl: EventsUserCaseImpl): EventsUseCase
}