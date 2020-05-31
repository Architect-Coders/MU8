package com.architect.coders.mu8.di

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.di.DataModule
import com.architect.coders.mu8.data.service.MarvelServiceManager
import com.architect.codes.mu8.di.DomainModule
import dagger.BindsInstance
import dagger.Component
import okhttp3.mockwebserver.MockWebServer
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class, DataModule::class, MockServerModule::class])
interface UiTestComponent : ApplicationComponent {

    val manager: MarvelServiceManager
    val mockWebServer: MockWebServer

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: DataApp): UiTestComponent
    }
}