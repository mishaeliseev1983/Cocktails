package com.melyseev.cocktails.di

import com.google.gson.GsonBuilder
import com.melyseev.cocktails.network.RetrofitService
import com.melyseev.cocktails.network.model.DrinkShortDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRecipeDtoMapper(): DrinkShortDtoMapper {
        return DrinkShortDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRecipeService(): RetrofitService {
        return Retrofit
            .Builder()
            .baseUrl("https://thecocktaildb.com/api/json/v1/1/")
            //.baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RetrofitService::class.java)
    }

}