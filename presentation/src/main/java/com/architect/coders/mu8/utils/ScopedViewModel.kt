package com.architect.coders.mu8.utils

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.architect.codes.mu8.common.Scope

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
