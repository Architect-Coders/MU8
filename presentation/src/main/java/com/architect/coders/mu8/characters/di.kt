package com.architect.coders.mu8.characters

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class CharactersActivityModule {

    @Provides
    fun charactersViewModelProvider(charactersRepositoryImpl: CharactersRepositoryImpl): CharactersViewModel {
        return CharactersViewModel(charactersRepositoryImpl)
    }

    @Provides
    fun charactersRepositoryProvider(application: DataApp): CharactersRepositoryImpl {
        return CharactersRepositoryImpl(application)
    }
}

@Subcomponent(modules = [(CharactersActivityModule::class)])
interface CharactersActivityComponent {
    val charactersViewModel: CharactersViewModel
}