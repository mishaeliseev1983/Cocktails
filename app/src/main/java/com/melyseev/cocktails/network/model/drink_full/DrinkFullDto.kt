package com.melyseev.cocktails.network.model.drink_full

import com.google.gson.annotations.SerializedName

data class DrinkFullDto (
    //val idDrink: String,
    //val strDrink: String,
    //val strDrinkThumb: String

    @SerializedName("idDrink")
    var idDrink: String,

    @SerializedName("strDrink")
    var strDrink: String,

    @SerializedName("strDrinkThumb")
    var strDrinkThumb: String,

    /*
    @SerializedName("strCategory")
    var strCategory: String,

    @SerializedName("strAlcoholic")
    var strAlcoholic: String,

    @SerializedName("strGlass")
    var strGlass: String,
*/
    @SerializedName("strInstructions")
    var strInstructions: String,

    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,

    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
)