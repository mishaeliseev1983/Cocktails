package com.melyseev.cocktails.di

import com.melyseev.cocktails.presentation.ui.drink_list.DrinkCategoryValues
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DrinkCategoryModule {

    @Provides
    @ViewModelScoped
    fun getCategoryValues(): DrinkCategoryValues{
        return DrinkCategoryValues()
    }
}