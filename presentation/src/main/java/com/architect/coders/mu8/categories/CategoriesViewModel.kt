package com.architect.coders.mu8.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.architect.coders.mu8.data.categories.CategoriesRepository
import com.architect.codes.mu8.categories.Category

class CategoriesViewModel(private val categoriesRepository: CategoriesRepository) : ViewModel() {

    sealed class UiModel {
        data class Content(val categories: List<Category>) : UiModel()
        data class Navigation(val categoryName: String) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    private fun refresh() {
        _model.value = UiModel.Content(categoriesRepository.categories)
    }

    fun onCategoryClicked(category: Category) {
        _model.value = UiModel.Navigation(category.title)
    }
}
