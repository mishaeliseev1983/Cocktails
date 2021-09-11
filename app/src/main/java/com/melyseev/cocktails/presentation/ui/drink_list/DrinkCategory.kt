package com.melyseev.cocktails.presentation.ui.drink_list

class DrinkCategory(val value: String){

    companion object{ val VALUES: MutableList<DrinkCategory> = mutableListOf()}
}

fun setDrinkCategories(list: List<String>){
    DrinkCategory.VALUES.clear()
    DrinkCategory.VALUES.addAll(list.map { DrinkCategory(it) })
}

fun getAllDrinkCategories(): List<DrinkCategory>{
    setDrinkCategories(getGlassValues())
    return DrinkCategory.VALUES
}

fun getDrinkCategory(value: String): DrinkCategory? {
    val map = DrinkCategory.VALUES.associateBy(DrinkCategory::value)
    return map[value]
}

fun getIndexDrinkCategory(value: String): Int{

   return 0 // DrinkCategory.VALUES.
}


/*
fun getDrinkCategory(value: String): DrinkCategory? {
    val map = DrinkCategory.values().associateBy(DrinkCategory::value)
    return map[value]
}

fun getIndexDrinkCategory(value: String): Int{
    val map = DrinkCategory.values().associateBy(DrinkCategory::value)
    return map[value]?.ordinal?:0
}

 */