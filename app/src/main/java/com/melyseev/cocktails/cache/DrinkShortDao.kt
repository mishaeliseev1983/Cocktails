package com.melyseev.cocktails.cache

import androidx.room.Dao
import androidx.room.Insert
import com.melyseev.cocktails.cache.model.DrinkShortEntity

@Dao
interface DrinkShortDao {

    @Insert
    suspend fun insertDrinkShort(drinkShortEntity: DrinkShortEntity): Long



}