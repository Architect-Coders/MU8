package com.architect.coders.mu8

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.di.ApplicationComponent
import com.architect.coders.mu8.di.DaggerApplicationComponent

open class MU8Application : DataApp() {

    lateinit var component: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        component = initDaggerComponent()
    }

    open fun initDaggerComponent() = DaggerApplicationComponent.factory().create(this)
}