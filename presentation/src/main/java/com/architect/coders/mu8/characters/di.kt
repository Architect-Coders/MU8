package com.architect.coders.mu8.characters

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import com.architect.codes.mu8.characters.CharactersRepository
import com.architect.codes.mu8.characters.CharactersUseCase
import com.architect.codes.mu8.characters.CharactersUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class CharactersActivityModule {

    @Provides
    fun characterViewModelProvider(charactersUseCase: CharactersUseCase) = CharactersViewModel(charactersUseCase)

    @Provides
    fun charactersUseCaseProvider(charactersRepository: CharactersRepository) = CharactersUseCaseImpl(charactersRepository)

    @Provides
    fun charactersRepositoryProvider(db: DataApp) : CharactersRepository = CharactersRepositoryImpl(db)
}

@Subcomponent(modules = [(CharactersActivityModule::class)])
interface CharactersActivityComponent {
    val charactersViewModel: CharactersViewModel
}