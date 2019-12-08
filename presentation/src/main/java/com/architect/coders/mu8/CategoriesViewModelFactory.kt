package com.architect.coders.mu8

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.architect.coders.mu8.data.local.categories.CategoriesRepository

class CategoriesViewModelFactory(private val categoriesRepository: CategoriesRepository): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = CategoriesViewModel(categoriesRepository) as T
}