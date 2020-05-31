package com.architect.coders.mu8.data.di.internal

import com.architect.coders.mu8.data.service.MarvelServiceManager
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ServerModule {

    @Singleton
    @Provides
    @Named("baseUrl")
    fun baseUrlProvider() = "https://gateway.marvel.com"

    @Singleton
    @Provides
    fun movieDBProvider(@Named("baseUrl") baseUrl: String) = MarvelServiceManager(baseUrl)

}