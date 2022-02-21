package com.melyseev.cocktails.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.melyseev.cocktails.cache.model.drinkFull.DrinkFullDao
import com.melyseev.cocktails.cache.model.drinkFull.DrinkFullEntity
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortDao
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortEntity
import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryDao
import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryEntity

@Database(entities = [DrinkShortEntity::class, DrinkQueryEntity::class, DrinkFullEntity::class], version = 4, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun drinkShortDao(): DrinkShortDao
    abstract fun drinkQueryDao(): DrinkQueryDao
    abstract fun drinkFullDao(): DrinkFullDao

    companion object{
        val DATABASE_NAME = "drinks_db"
    }
}