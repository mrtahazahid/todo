package com.tahazahid.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tahazahid.todo.repository.BuyRepository

class BuyViewModelFactory(private val buyRepository: BuyRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BuyViewModel(buyRepository) as T
    }
}