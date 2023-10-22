package com.tahazahid.todo.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tahazahid.todo.api.ApiInterface
import com.tahazahid.todo.models.BuyListResponse
import com.tahazahid.todo.room.SellDataBase
import com.tahazahid.todo.utils.MyUtils

class BuyRepository(private val apiInterface: ApiInterface, private val sellDataBase: SellDataBase, private val context: Context) {

    private val buyListLiveData = MutableLiveData<BuyListResponse>()
    val buyLiveData : LiveData<BuyListResponse>
        get() = buyListLiveData

    suspend fun getBuyList(){
        if(MyUtils.isInternetAvailable(context)){
            val result = apiInterface.getBuyList()
            if(result.body() != null){
                sellDataBase.sellDAO().insertSellData(result.body()!!)
                buyListLiveData.postValue(result.body())
            }
        }
    }

}