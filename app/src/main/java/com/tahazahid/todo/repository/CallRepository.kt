package com.tahazahid.todo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tahazahid.todo.api.ApiInterface
import com.tahazahid.todo.models.CallListResponse

class CallRepository(private val apiInterface: ApiInterface) {

    private val callListLiveData = MutableLiveData<CallListResponse>()
    val callLiveData : LiveData<CallListResponse>
        get() = callListLiveData

    suspend fun getCallList(){
        val result = apiInterface.getCallList()
        if(result.body() != null){
            callListLiveData.postValue(result.body())
        }
    }
}