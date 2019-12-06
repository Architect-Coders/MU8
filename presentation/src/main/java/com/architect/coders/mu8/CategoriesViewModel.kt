package com.architect.coders.mu8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.architect.coders.mu8.data.local.categories.CategoriesRepository
import com.architect.codes.mu8.model.Category

class CategoriesViewModel(private val categoriesRepository: CategoriesRepository): ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    sealed class UiModel {
        class Content(val categories: List<Category>) : UiModel()
        class Navigation(val category: Category): UiModel()
    }

    private fun refresh() {
        _model.value = UiModel.Content(categoriesRepository.categories)
    }

    fun onCategoryClicked(category: Category) {
        _model.value = UiModel.Navigation(category)
    }
}