package com.melyseev.cocktails.cache.model.drinkQuery

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface DrinkQueryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDrinkQuery(drinkQueryEntity: DrinkQueryEntity): Long

    @Query("SELECT listIdDrinks FROM drink_query WHERE `query` = :query1")
    suspend fun getListIdDrinks(query1: String): String?

}