package com.melyseev.cocktails.cache.model.drinkQuery

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "drink_query")
class DrinkQueryEntity(
/*
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idQuery")
    val idQuery: String,

 */

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "query")
    val query: String,

    @ColumnInfo(name = "listIdDrinks")
    val listIdDrinks: String
)