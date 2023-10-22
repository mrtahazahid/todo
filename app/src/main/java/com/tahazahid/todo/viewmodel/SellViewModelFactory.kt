package com.tahazahid.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tahazahid.todo.repository.SellRepository

class SellViewModelFactory(private val sellRepository: SellRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SellViewModel(sellRepository) as T
    }
}