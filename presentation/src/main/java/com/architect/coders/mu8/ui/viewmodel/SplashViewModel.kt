package com.architect.coders.mu8.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.architect.coders.mu8.BuildConfig
import com.architect.coders.mu8.utils.Scope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel(), Scope by Scope.Impl() {

    private val TIME_SLEEP: Long = 5000

    sealed class UiModel {
        class GetVersion(val versionName: String) : UiModel()
        object Navigation : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) onGetVersion()
            return _model
        }

    init {
        initScope()
    }

    private fun onGetVersion() {
        launch {
            _model.value = UiModel.GetVersion(onStringVersion())
            delay(TIME_SLEEP)
            onChangeOfNavigationStatus()
        }
    }

    private fun onChangeOfNavigationStatus() {
       _model.value =
           UiModel.Navigation
    }

    private fun onStringVersion() = BuildConfig.VERSION_NAME

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}
