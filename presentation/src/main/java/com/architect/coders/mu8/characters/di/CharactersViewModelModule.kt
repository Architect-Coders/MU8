package com.architect.coders.mu8.characters.di

import com.architect.coders.mu8.characters.CharactersViewModel
import com.architect.codes.mu8.characters.CharactersUseCase
import dagger.Module
import dagger.Provides

@Module
class CharactersViewModelModule {

    @Provides
    fun providesCharactersViesModel(charactersUseCase: CharactersUseCase) = CharactersViewModel(charactersUseCase)
}