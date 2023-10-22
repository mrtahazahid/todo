package com.tahazahid.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tahazahid.todo.repository.CallRepository

class CallViewModelFactory(private val callRepository: CallRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CallViewModel(callRepository) as T
    }
}