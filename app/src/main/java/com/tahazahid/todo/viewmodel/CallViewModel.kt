package com.tahazahid.todo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tahazahid.todo.models.CallListResponse
import com.tahazahid.todo.repository.CallRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CallViewModel(private val callRepository: CallRepository) : ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            callRepository.getCallList()
        }
    }

    val callList : LiveData<CallListResponse>
        get() = callRepository.callLiveData
}