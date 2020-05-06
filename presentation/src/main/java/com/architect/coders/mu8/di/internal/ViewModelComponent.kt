package com.architect.coders.mu8.di.internal

import com.architect.coders.mu8.categories.CategoriesViewModel
import com.architect.coders.mu8.characters.CharactersViewModel
import com.architect.coders.mu8.characters.detail.CharactersDetailViewModel
import com.architect.coders.mu8.comics.ComicsViewModel
import com.architect.coders.mu8.events.EventsViewModel
import com.architect.coders.mu8.splash.SplashViewModel
import dagger.Subcomponent

@Subcomponent(modules = [(ViewModelModule::class)])
interface ViewModelComponent {
    val splashViewModel: SplashViewModel
    val categoriesViewModelModule: CategoriesViewModel
    val charactersViewModel: CharactersViewModel
    val charactersDetailViewModel: CharactersDetailViewModel
    val comicsViewModel: ComicsViewModel
    val eventsViewModel: EventsViewModel
}