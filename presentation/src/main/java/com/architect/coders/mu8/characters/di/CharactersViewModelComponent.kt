package com.architect.coders.mu8.characters.di

import com.architect.coders.mu8.characters.CharactersViewModel
import dagger.Subcomponent

@Subcomponent(modules = [(CharactersViewModelModule::class)])
interface CharactersViewModelComponent {
    val charactersViewModel: CharactersViewModel
}