package com.architect.coders.mu8

import com.architect.coders.mu8.di.DaggerUiTestComponent

class TestApp : MU8Application() {
    override fun initDaggerComponent() = DaggerUiTestComponent.factory().create(this)
}