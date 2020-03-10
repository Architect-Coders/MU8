package com.architect.coders.mu8.di

import com.architect.coders.mu8.characters.CharactersActivityComponent
import com.architect.coders.mu8.characters.CharactersActivityModule
import com.architect.coders.mu8.data.DataApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface MU8Component {

    fun plus(module: CharactersActivityModule): CharactersActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: DataApp): MU8Component
    }
}