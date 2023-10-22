package com.tahazahid.todo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tahazahid.todo.models.BuyListResponseItem

@Database(entities = [BuyListResponseItem::class] , version = 1, exportSchema = false)
abstract class SellDataBase : RoomDatabase() {

    abstract fun sellDAO() : RoomDAO

    companion object{
        private var INSTANCE : SellDataBase? = null

        fun getDataBase(context: Context) : SellDataBase{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    SellDataBase::class.java,
                    "todoDB"
                ).build()
            }
            return INSTANCE!!
        }
    }
}