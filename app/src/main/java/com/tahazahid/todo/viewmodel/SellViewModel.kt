package com.tahazahid.todo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tahazahid.todo.models.BuyListResponseItem
import com.tahazahid.todo.repository.SellRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SellViewModel(private val sellRepository: SellRepository) : ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            sellRepository.getSellList()
        }
    }

    val sellList : LiveData<List<BuyListResponseItem>>
        get() = sellRepository.sellLiveData
}