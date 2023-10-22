package com.tahazahid.todo.api

import com.tahazahid.todo.models.BuyListResponse
import com.tahazahid.todo.models.CallListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("call")
    suspend fun getCallList() : Response<CallListResponse>

    @GET("buy")
    suspend fun getBuyList() : Response<BuyListResponse>
}