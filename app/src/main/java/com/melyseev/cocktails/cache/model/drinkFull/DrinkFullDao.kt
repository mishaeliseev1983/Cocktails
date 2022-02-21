package com.melyseev.cocktails.cache.model.drinkFull

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortEntity


@Dao
interface DrinkFullDao {
    @Insert
    suspend fun insertDrinkFull(drinkFullEntity: DrinkFullEntity): Long

    @Query("SELECT * FROM drink_full WHERE `idDrink` = :idDrinkOne ")
    suspend fun getFullDrinkById(idDrinkOne : String
    ): DrinkFullEntity
}