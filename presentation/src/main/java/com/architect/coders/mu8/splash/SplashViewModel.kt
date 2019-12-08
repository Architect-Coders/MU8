package com.architect.coders.mu8.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.BuildConfig
import com.architect.coders.mu8.utils.ScopedViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TIME_SLEEP: Long = 2000

class SplashViewModel : ScopedViewModel() {

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
            _model.value = UiModel.Navigation
        }
    }

    private fun onStringVersion() = BuildConfig.VERSION_NAME
}
