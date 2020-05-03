package com.architect.coders.mu8.data.di.internal

import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import com.architect.coders.mu8.data.charactersDetail.CharacterDetailRepositoryImpl
import com.architect.coders.mu8.data.comics.ComicRepositoryImpl
import com.architect.coders.mu8.data.events.EventsRepositoryImpl
import com.architect.codes.mu8.callback.ComicRepository
import com.architect.codes.mu8.characters.CharactersRepository
import com.architect.codes.mu8.characters.detail.CharacterDetailRepository
import com.architect.codes.mu8.events.EventsRepository
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryImplementationsModule::class])
internal abstract class RepositoryModule {

    @Binds
    abstract fun provideCharactersRepository(impl: CharactersRepositoryImpl): CharactersRepository

    @Binds
    abstract fun provideCharacterDetailRepository(impl: CharacterDetailRepositoryImpl): CharacterDetailRepository

    @Binds
    abstract fun provideComicRepository(impl: ComicRepositoryImpl): ComicRepository

    @Binds
    abstract fun provideEventsRepository(impl: EventsRepositoryImpl): EventsRepository
}