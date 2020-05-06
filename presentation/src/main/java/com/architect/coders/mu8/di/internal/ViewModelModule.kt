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
import kotlinx.coroutines.CoroutineDispatcher

@Module(includes = [DispatcherModule::class])
class ViewModelModule {

    @Provides
    fun provideSplashViewModel(uiDispatcher: CoroutineDispatcher) = SplashViewModel(uiDispatcher)

    @Provides
    fun provideCategoriesViewModel(categoriesRepository: CategoriesRepository) = CategoriesViewModel(categoriesRepository)

    @Provides
    fun provideCharactersViewModel(
        charactersUseCase: CharactersUseCase,
        uiDispatcher: CoroutineDispatcher
    ) = CharactersViewModel(charactersUseCase, uiDispatcher)

    @Provides
    fun provideCharactersDetailViewModel(
        characterDetailUseCase: CharacterDetailUseCase,
        charactersUseCase: CharactersUseCase,
        uiDispatcher: CoroutineDispatcher
    ) = CharactersDetailViewModel(characterDetailUseCase, charactersUseCase, uiDispatcher)

    @Provides
    fun provideComicsViewModel(comicUseCase: ComicUseCase, uiDispatcher: CoroutineDispatcher) = ComicsViewModel(comicUseCase, uiDispatcher)

    @Provides
    fun provideEventsViewModel(
        eventsUseCase: EventsUseCase,
        uiDispatcher: CoroutineDispatcher
    ) = EventsViewModel(eventsUseCase, uiDispatcher)
}