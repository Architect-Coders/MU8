package com.architect.coders.mu8.di.internal

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class DispatcherModule {

    @Provides
    fun provideUiDispatcher(): CoroutineDispatcher = Dispatchers.Main
}