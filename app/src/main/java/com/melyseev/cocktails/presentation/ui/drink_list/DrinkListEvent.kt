package com.melyseev.cocktails.presentation.ui.drink_list

sealed class DrinkListEvent {
    object NewFilterAlcoholicEvent: DrinkListEvent()
    //object NextPageEvent: DrinkListEvent()
}