package com.architect.coders.mu8.data.di.internal

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.categories.CategoriesRepository
import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import com.architect.coders.mu8.data.charactersDetail.CharacterDetailRepositoryImpl
import com.architect.coders.mu8.data.comics.ComicRepositoryImpl
import com.architect.coders.mu8.data.events.EventsRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
internal class RepositoryImplementationsModule {

    @Provides
    fun provideCategoriesRepository() = CategoriesRepository()

    @Provides
    fun provideCharactersRepositoryImpl(app: DataApp) = CharactersRepositoryImpl(app)

    @Provides
    fun provideCharacterDetailRepositoryImpl(app: DataApp) = CharacterDetailRepositoryImpl(app)

    @Provides
    fun provideComicRepositoryImpl(app: DataApp) = ComicRepositoryImpl(app)

    @Provides
    fun provideEventsRepositoryImpl(app: DataApp) = EventsRepositoryImpl(app)
}