package com.tahazahid.todo.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tahazahid.todo.api.ApiInterface
import com.tahazahid.todo.models.BuyListResponseItem
import com.tahazahid.todo.room.SellDataBase

class SellRepository(private val apiInterface: ApiInterface, private val sellDataBase: SellDataBase, private val context: Context) {

    private val sellListLiveData = MutableLiveData<List<BuyListResponseItem>>()
    val sellLiveData : LiveData<List<BuyListResponseItem>>
        get() = sellListLiveData

    suspend fun getSellList(){
        val sellListData = sellDataBase.sellDAO().getSellData()
        sellListLiveData.postValue(sellListData)
    }

}