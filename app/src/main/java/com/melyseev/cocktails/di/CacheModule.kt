package com.melyseev.cocktails.di

import androidx.room.Room
import com.melyseev.cocktails.BaseApplication
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortDao
import com.melyseev.cocktails.cache.database.AppDatabase
import com.melyseev.cocktails.cache.model.drinkFull.DrinkFullDao
import com.melyseev.cocktails.cache.model.drinkFull.DrinkFullEntityMapper
import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryDao
import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryEntity
import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryEntityMapper
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {


    @Singleton
    @Provides
    fun provideDataBase(app: BaseApplication): AppDatabase{
        return Room.databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun provideShortDao(appDatabase: AppDatabase): DrinkShortDao {
        return appDatabase.drinkShortDao()
    }

    @Singleton
    @Provides
    fun provideQueryDao(appDatabase: AppDatabase): DrinkQueryDao {
        return appDatabase.drinkQueryDao()
    }


    @Singleton
    @Provides
    fun provideFullDao(appDatabase: AppDatabase): DrinkFullDao {
        return appDatabase.drinkFullDao()
    }


}