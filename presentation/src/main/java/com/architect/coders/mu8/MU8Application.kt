package com.architect.coders.mu8

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.di.DaggerApplicationComponent
import com.architect.coders.mu8.di.ApplicationComponent

class MU8Application : DataApp() {

    lateinit var component: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
            .factory()
            .create(this)
    }
}