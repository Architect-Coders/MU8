package com.architect.codes.mu8.di.internal

import com.architect.codes.mu8.callback.ComicRepository
import com.architect.codes.mu8.characters.CharactersRepository
import com.architect.codes.mu8.characters.CharactersUseCaseImpl
import com.architect.codes.mu8.characters.detail.CharacterDetailRepository
import com.architect.codes.mu8.characters.detail.CharacterDetailUseCaseImpl
import com.architect.codes.mu8.comics.ComicsUseCaseImpl
import com.architect.codes.mu8.events.EventsRepository
import com.architect.codes.mu8.events.EventsUserCaseImpl
import dagger.Module
import dagger.Provides

@Module
internal class UseCaseImplementationsModule {

    @Provides
    fun provideCharactersUseCaseImpl(charactersRepository: CharactersRepository) = CharactersUseCaseImpl(charactersRepository)

    @Provides
    fun provideCharacterDetailUseCaseImpl(
        charactersDetailRepository: CharacterDetailRepository
    ) = CharacterDetailUseCaseImpl(charactersDetailRepository)

    @Provides
    fun provideComicUseCaseImpl(comicRepository: ComicRepository) = ComicsUseCaseImpl(comicRepository)

    @Provides
    fun provideEventsUseCaseImpl(eventsRepository: EventsRepository) = EventsUserCaseImpl(eventsRepository)
}