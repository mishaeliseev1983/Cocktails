package com.melyseev.cocktails.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.melyseev.cocktails.cache.DrinkShortDao
import com.melyseev.cocktails.cache.model.DrinkShortEntity

@Database(entities = [DrinkShortEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun drinkShortDao(): DrinkShortDao

    companion object{
        val DATABASE_NAME = "drinks_db"
    }
}