package com.melyseev.cocktails.cache.model.drinkShort

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drink_short")
class DrinkShortEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idDrink")
    val idDrink: String,

    @ColumnInfo(name = "strDrink")
    val strDrink: String,

    @ColumnInfo(name = "strDrinkThumb")
    val strDrinkThumb: String

)