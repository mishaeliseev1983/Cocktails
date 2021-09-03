package com.melyseev.cocktails.network.response

import com.google.gson.annotations.SerializedName
import com.melyseev.cocktails.network.model.drink_short.DrinkShortDto

class DrinkFilterResponse (
    @SerializedName("drinks")
    val results: List<DrinkShortDto>)
