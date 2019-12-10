package com.architect.coders.mu8.ui.common

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel

abstract class ScopedViewModel : ViewModel(), Scope by Scope.Implementation() {

    init {
        this.initScope()
    }

    @CallSuper
    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}