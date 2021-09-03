package com.melyseev.cocktails.network.response

import com.google.gson.annotations.SerializedName
import com.melyseev.cocktails.network.model.drink_full.DrinkFullDto

//must return 1 element in list
class DrinkFullbyIdResponse (
    @SerializedName("drinks")
    val result: List<DrinkFullDto>)