package com.melyseev.cocktails.cache.model.drinkShort

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortEntity
import com.melyseev.cocktails.interactors.drink.GetFullbyIdDrink

@Dao
interface DrinkShortDao {

    @Insert
    suspend fun insertDrinkShort(drinkShortEntity: DrinkShortEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertListDrinkShort(listShortEntity: List<DrinkShortEntity>): LongArray

    @Query("SELECT * FROM drink_short")
    suspend fun getAllShortDrinks(
    ): List<DrinkShortEntity>

    @Query("SELECT * FROM drink_short WHERE `idDrink` in  (:ids) order by idDrink")
    suspend fun getShortDrinksByIds(ids : List<String>
    ): List<DrinkShortEntity>

}