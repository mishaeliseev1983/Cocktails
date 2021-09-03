package com.melyseev.cocktails.network.model.drink_short

import com.google.gson.annotations.SerializedName

data class DrinkShortDto (
    //val idDrink: String,
    //val strDrink: String,
    //val strDrinkThumb: String

    @SerializedName("idDrink")
    var idDrink: String,

    @SerializedName("strDrink")
    var strDrink: String,

    @SerializedName("strDrinkThumb")
    var strDrinkThumb: String,
)