package com.architect.coders.mu8

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.di.DaggerMU8Component
import com.architect.coders.mu8.di.MU8Component

class MU8Application : DataApp() {

    lateinit var component: MU8Component
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerMU8Component
            .factory()
            .create(this)
    }
}