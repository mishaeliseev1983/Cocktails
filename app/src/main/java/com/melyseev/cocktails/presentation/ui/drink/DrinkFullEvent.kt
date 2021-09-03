package com.melyseev.cocktails.presentation.ui.drink


sealed class DrinkFullEvent {

    data class GetDrinkFilterById(val idDrink: String): DrinkFullEvent()
    //object NextPageEvent: DrinkListEvent()
}