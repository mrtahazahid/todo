package com.tahazahid.todo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tahazahid.todo.api.ApiInterface
import com.tahazahid.todo.api.ApiUtilities.TAG
import com.tahazahid.todo.models.BuyListResponse
import com.tahazahid.todo.models.BuyListResponseItem
import com.tahazahid.todo.room.SellDataBase

class BuyRepository(private val apiInterface: ApiInterface, private val sellDataBase: SellDataBase) {

    private val buyListLiveData = MutableLiveData<BuyListResponse>()
    val buyLiveData : LiveData<BuyListResponse>
        get() = buyListLiveData

    suspend fun getBuyList(){
        val result = apiInterface.getBuyList()
        if(result.body() != null){
            sellDataBase.sellDAO().insertSellData(result.body()!!)
            Log.d(TAG, "getBuyList: ${result.body()!!}")
            buyListLiveData.postValue(result.body())
        }
    }

}