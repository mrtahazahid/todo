package com.tahazahid.todo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tahazahid.todo.models.BuyListResponse
import com.tahazahid.todo.models.BuyListResponseItem

@Dao
interface RoomDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSellData(sellData : BuyListResponse)

    @Query("SELECT * FROM ItemToSell")
    fun getSellData() : List<BuyListResponseItem>
}