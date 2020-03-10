package com.architect.coders.mu8.di

import com.architect.coders.mu8.characters.di.CharactersViewModelComponent
import com.architect.coders.mu8.characters.di.CharactersViewModelModule
import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.di.DataModule
import com.architect.codes.mu8.di.DomainModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class, DataModule::class])
interface ApplicationComponent {

    fun plus(module: CharactersViewModelModule): CharactersViewModelComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: DataApp): ApplicationComponent
    }
}