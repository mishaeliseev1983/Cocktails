package com.melyseev.cocktails.di

import com.melyseev.cocktails.cache.model.drinkFull.DrinkFullDao
import com.melyseev.cocktails.cache.model.drinkFull.DrinkFullEntityMapper
import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryDao
import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryEntityMapper
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortDao
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortEntityMapper
import com.melyseev.cocktails.interactors.drink.GetFullbyIdDrink
import com.melyseev.cocktails.interactors.drink_list.FilterDrinks
import com.melyseev.cocktails.network.RetrofitService
import com.melyseev.cocktails.network.model.drink_full.DrinkFullDto
import com.melyseev.cocktails.network.model.drink_full.DrinkFullDtoMapper
import com.melyseev.cocktails.network.model.drink_short.DrinkShortDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorsModule {

    @ViewModelScoped
    @Provides
    fun provideFilterDrink(
        //recipeDao: RecipeDao,
        retrofitService: RetrofitService,
        //recipeEntityMapper: RecipeEntityMapper,
        drinkShortDtoMapper: DrinkShortDtoMapper,

        shortDao: DrinkShortDao,
        shortEntityMapper: DrinkShortEntityMapper,

        queryDao: DrinkQueryDao,
        queryEntityMapper: DrinkQueryEntityMapper

    ): FilterDrinks {
        return FilterDrinks(
            //recipeDao = recipeDao,
            retrofitService = retrofitService,
            //recipeEntityMapper = recipeEntityMapper,
            drinkShortDtoMapper = drinkShortDtoMapper,
            shortDao = shortDao,
            shortEntityMapper = shortEntityMapper,
            queryDao = queryDao,
            queryEntityMapper = queryEntityMapper
            )
    }


    @ViewModelScoped
    @Provides
    fun provideFullbyIdDrink(
        //recipeDao: RecipeDao,
        retrofitService: RetrofitService,
        //recipeEntityMapper: RecipeEntityMapper,
        drinkFullDtoMapper: DrinkFullDtoMapper,
        fullDao: DrinkFullDao,
        fullEntityMapper: DrinkFullEntityMapper,
    ):  GetFullbyIdDrink {
        return GetFullbyIdDrink(
            //recipeDao = recipeDao,
            retrofitService = retrofitService,
            //recipeEntityMapper = recipeEntityMapper,
            drinkFullDtoMapper = drinkFullDtoMapper,
            fullDao = fullDao,
            fullEntityMapper = fullEntityMapper)
    }
}