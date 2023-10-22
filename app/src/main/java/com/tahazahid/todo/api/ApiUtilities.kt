package com.tahazahid.todo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {
    val BASE_URL = "https://my-json-server.typicode.com/imkhan334/demo-1/"
    val TAG = "TODOMYAPP"

    fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}