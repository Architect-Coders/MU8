package com.architect.coders.mu8.data.di.internal

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.categories.CategoriesRepository
import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import com.architect.coders.mu8.data.charactersDetail.CharacterDetailRepositoryImpl
import com.architect.coders.mu8.data.comics.ComicRepositoryImpl
import com.architect.coders.mu8.data.events.EventsRepositoryImpl
import com.architect.coders.mu8.data.service.MarvelServiceManager
import dagger.Module
import dagger.Provides

@Module
internal class RepositoryImplementationsModule {

    @Provides
    fun provideCategoriesRepository() = CategoriesRepository()

    @Provides
    fun provideCharactersRepositoryImpl(app: DataApp, manager: MarvelServiceManager) = CharactersRepositoryImpl(app, manager)

    @Provides
    fun provideCharacterDetailRepositoryImpl(app: DataApp, manager: MarvelServiceManager) = CharacterDetailRepositoryImpl(app, manager)

    @Provides
    fun provideComicRepositoryImpl(app: DataApp, manager: MarvelServiceManager) = ComicRepositoryImpl(app, manager)

    @Provides
    fun provideEventsRepositoryImpl(app: DataApp, manager: MarvelServiceManager) = EventsRepositoryImpl(app, manager)
}