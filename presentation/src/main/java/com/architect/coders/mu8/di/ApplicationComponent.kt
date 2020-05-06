package com.architect.coders.mu8.di

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.di.DataModule
import com.architect.coders.mu8.di.internal.ViewModelComponent
import com.architect.coders.mu8.di.internal.ViewModelModule
import com.architect.codes.mu8.di.DomainModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class, DataModule::class])
interface ApplicationComponent {

    fun plus(module: ViewModelModule): ViewModelComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: DataApp): ApplicationComponent
    }
}