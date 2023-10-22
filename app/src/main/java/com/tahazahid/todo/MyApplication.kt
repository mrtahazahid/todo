package com.tahazahid.todo

import android.app.Application
import com.tahazahid.todo.api.ApiInterface
import com.tahazahid.todo.api.ApiUtilities
import com.tahazahid.todo.repository.BuyRepository
import com.tahazahid.todo.room.SellDataBase

class MyApplication : Application() {
    lateinit var apiInterface: ApiInterface
    lateinit var buyRepository: BuyRepository

    override fun onCreate() {
        super.onCreate()

        apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val dataBase = SellDataBase.getDataBase(applicationContext)
        buyRepository = BuyRepository(apiInterface, dataBase)
    }
}