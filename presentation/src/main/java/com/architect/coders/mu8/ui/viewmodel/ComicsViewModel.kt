package com.architect.coders.mu8.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.architect.coders.mu8.ui.common.Scope
import com.architect.coders.mu8.ui.viewmodel.ComicsViewModel.UiModel.*
import com.architect.codes.mu8.interactor.comics.IComicUseCase
import com.architect.codes.mu8.model.Comic
import kotlinx.coroutines.launch

class ComicsViewModel(private val useCase: IComicUseCase) : ViewModel(),
    Scope by Scope.Impl() {

    sealed class UiModel {
        object ShowLoading : UiModel()
        object InternetError : UiModel()
        class LoadData(val comics: List<Comic>) : UiModel()
        class NavigateTo(val cominc: Comic) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()

    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) loadData()
            return _model
        }

    init {
        initScope()
    }

    private fun loadData() {
        launch {
            _model.value = ShowLoading

            try {
                _model.value = LoadData(useCase.getComics())
            } catch (e: Exception) {
                _model.value = InternetError
            }
        }
    }

    fun onComicClicked(comic: Comic) {
        _model.value = NavigateTo(comic)
    }

    override fun onCleared() {
        destroyScope()
    }

}