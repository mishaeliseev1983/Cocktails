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

    /*
    @SerializedName("strIngredient1")
    var strIngredient1: String,

    @SerializedName("strIngredient2")
    var strIngredient2: String,

    @SerializedName("strIngredient3")
    var strIngredient3: String,

    @SerializedName("strIngredient4")
    var strIngredient4: String,*/
)