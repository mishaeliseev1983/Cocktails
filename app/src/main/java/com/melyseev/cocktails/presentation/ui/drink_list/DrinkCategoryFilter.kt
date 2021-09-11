package com.melyseev.cocktails.presentation.ui.drink_list

enum class DrinkCategoryFilter(val value:String) {

    ALCOHOLIC("Alcoholic"),
    INGREDIENTS("Ingredients"),
    GLASS("Glass"),
    CATEGORY("Category")
}

fun getAllDrinkFilterCategories(): List<String>{
    return listOf(DrinkCategoryFilter.ALCOHOLIC.value, DrinkCategoryFilter.INGREDIENTS.value,
        DrinkCategoryFilter.GLASS.value,DrinkCategoryFilter.CATEGORY.value )
}


enum class ALCOHOLIC_Filter(val value:String) {
    ALCO("Alcoholic"),
    NONALCO("Non alcoholic"),
    OPTIONAL("Optional alcohol")
}

fun getAlcoholicValues(): List<String>{
    return listOf(ALCOHOLIC_Filter.ALCO.value,
        ALCOHOLIC_Filter.NONALCO.value,
        ALCOHOLIC_Filter.OPTIONAL.value)
}


enum class INGREDIENTS_Filter(val value:String) {
    LIGHT_RUM("Light rum"),
    APPLEJACK("Applejack"),
    GIN("Gin")
}

fun getIngredientsValues(): List<String>{
    return listOf(INGREDIENTS_Filter.LIGHT_RUM.value,
        INGREDIENTS_Filter.APPLEJACK.value,
        INGREDIENTS_Filter.GIN.value)
}


enum class GLASS_Filter(val value:String) {
    GLASS1("Highball_glass"),
    GLASS2("Cocktail_glass"),
    GLASS3("Old-fashioned_glass")
}

fun getGlassValues(): List<String>{
    return listOf(GLASS_Filter.GLASS1.value,
        GLASS_Filter.GLASS2.value,
        GLASS_Filter.GLASS3.value)
}

enum class CATEGORY_Filter(val value:String) {
    CAT1("Ordinary Drink"),
    CAT2("Cocktail"),
    CAT3("\"Milk / Float / Shake")
}

fun getCategoryValues(): List<String>{
    return listOf(CATEGORY_Filter.CAT1.value,
        CATEGORY_Filter.CAT2.value,
        CATEGORY_Filter.CAT3.value)
}