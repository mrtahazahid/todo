package com.tahazahid.todo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tahazahid.todo.models.BuyListResponse
import com.tahazahid.todo.repository.BuyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BuyViewModel(private val buyRepository: BuyRepository) : ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            buyRepository.getBuyList()
        }
    }

    val buyList : LiveData<BuyListResponse>
        get() = buyRepository.buyLiveData
}