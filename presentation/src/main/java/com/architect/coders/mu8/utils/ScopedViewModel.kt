package com.architect.coders.mu8.utils

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.architect.codes.mu8.common.Scope
import kotlinx.coroutines.CoroutineDispatcher

abstract class ScopedViewModel(uiDispatcher: CoroutineDispatcher) : ViewModel(), Scope by Scope.Implementation(uiDispatcher) {

    init {
        this.initScope()
    }

    @CallSuper
    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}
