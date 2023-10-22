package com.tahazahid.todo.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tahazahid.todo.api.ApiInterface
import com.tahazahid.todo.models.CallListResponse
import com.tahazahid.todo.utils.MyUtils

class CallRepository(private val apiInterface: ApiInterface, private val context: Context) {

    private val callListLiveData = MutableLiveData<CallListResponse>()
    val callLiveData : LiveData<CallListResponse>
        get() = callListLiveData

    suspend fun getCallList(){
        if(MyUtils.isInternetAvailable(context)){
            val result = apiInterface.getCallList()
            if(result.body() != null){
                callListLiveData.postValue(result.body())
            }
        }
    }
}