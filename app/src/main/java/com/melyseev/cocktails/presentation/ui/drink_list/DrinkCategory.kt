package com.melyseev.cocktails.presentation.ui.drink_list

enum class DrinkCategory(val value: String){
    ALCO("Alcoholic"),
    NONALCO("Non alcoholic"),
    OPTIONAL("Optional alcohol")
}

fun getAllDrinkCategories(): List<DrinkCategory>{
    return listOf(DrinkCategory.ALCO, DrinkCategory.NONALCO, DrinkCategory.OPTIONAL)
}

fun getDrinkCategory(value: String): DrinkCategory? {
    val map = DrinkCategory.values().associateBy(DrinkCategory::value)
    return map[value]
}

fun getIndexDrinkCategory(value: String): Int{
    val map = DrinkCategory.values().associateBy(DrinkCategory::value)
    return map[value]?.ordinal?:0
}