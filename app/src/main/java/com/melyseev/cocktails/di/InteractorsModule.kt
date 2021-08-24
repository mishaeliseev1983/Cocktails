package com.melyseev.cocktails.di

import com.melyseev.cocktails.interactors.drink_list.FilterDrinks
import com.melyseev.cocktails.network.RetrofitService
import com.melyseev.cocktails.network.model.DrinkShortDtoMapper
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
    ): FilterDrinks {
        return FilterDrinks(
            //recipeDao = recipeDao,
            retrofitService = retrofitService,
            //recipeEntityMapper = recipeEntityMapper,
            drinkShortDtoMapper = drinkShortDtoMapper)
    }
}