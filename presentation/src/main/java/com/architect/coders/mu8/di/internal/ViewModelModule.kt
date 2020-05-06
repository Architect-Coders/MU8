package com.architect.coders.mu8.di.internal

import com.architect.coders.mu8.categories.CategoriesViewModel
import com.architect.coders.mu8.characters.CharactersViewModel
import com.architect.coders.mu8.characters.detail.CharactersDetailViewModel
import com.architect.coders.mu8.comics.ComicsViewModel
import com.architect.coders.mu8.data.categories.CategoriesRepository
import com.architect.coders.mu8.events.EventsViewModel
import com.architect.coders.mu8.splash.SplashViewModel
import com.architect.codes.mu8.characters.CharactersUseCase
import com.architect.codes.mu8.characters.detail.CharacterDetailUseCase
import com.architect.codes.mu8.comics.ComicUseCase
import com.architect.codes.mu8.events.EventsUseCase
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideSplashViewModel() = SplashViewModel()

    @Provides
    fun provideCategoriesViewModel(categoriesRepository: CategoriesRepository) = CategoriesViewModel(categoriesRepository)

    @Provides
    fun provideCharactersViewModel(charactersUseCase: CharactersUseCase) = CharactersViewModel(charactersUseCase)

    @Provides
    fun provideCharactersDetailViewModel(
        characterDetailUseCase: CharacterDetailUseCase,
        charactersUseCase: CharactersUseCase
    ) = CharactersDetailViewModel(characterDetailUseCase, charactersUseCase)

    @Provides
    fun provideComicsViewModel(comicUseCase: ComicUseCase) = ComicsViewModel(comicUseCase)

    @Provides
    fun provideEventsViewModel(eventsUseCase: EventsUseCase) = EventsViewModel(eventsUseCase)
}