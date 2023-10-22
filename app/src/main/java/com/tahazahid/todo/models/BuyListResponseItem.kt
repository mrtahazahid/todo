package com.tahazahid.todo.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ItemToSell")
data class BuyListResponseItem(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Int,
    val quantity: Int,
    val type: Int
)