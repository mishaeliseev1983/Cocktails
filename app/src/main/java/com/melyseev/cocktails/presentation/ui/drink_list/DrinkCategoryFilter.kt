package com.melyseev.cocktails.presentation.ui.drink_list



class DrinkCategoryValues{
    var currentCategory ="Alcoholic"
    private var listFilterValues = mutableListOf<String>()
    init{
        listFilterValues= getValuesByCurrentCategory()
    }

    fun getValuesByCurrentCategory() =
            when (currentCategory) {
                (DrinkCategoryFilter.ALCOHOLIC.value) -> getAlcoholicValues()
                (DrinkCategoryFilter.INGREDIENTS.value) -> getIngredientsValues()
                (DrinkCategoryFilter.GLASS.value) -> getGlassValues()
                (DrinkCategoryFilter.CATEGORY.value) -> getCategoryValues()
                else -> mutableListOf()
            }

    fun getIndexDrinkCategoryValue(value: String): Int =
        when (currentCategory) {
            (DrinkCategoryFilter.ALCOHOLIC.value) -> getAlcoholicValues().indexOf(value)
            (DrinkCategoryFilter.INGREDIENTS.value) -> getIngredientsValues().indexOf(value)
            (DrinkCategoryFilter.GLASS.value) -> getGlassValues().indexOf(value)
            (DrinkCategoryFilter.CATEGORY.value) -> getCategoryValues().indexOf(value)
            else -> -1
        }
}

enum class DrinkCategoryFilter(val value:String) {

    ALCOHOLIC("Alcoholic"),
    INGREDIENTS("Ingredients"),
    GLASS("Glass"),
    CATEGORY("Category")
}

fun getAllDrinkFilterCategories(): MutableList<String>{
    return mutableListOf(DrinkCategoryFilter.ALCOHOLIC.value, DrinkCategoryFilter.INGREDIENTS.value,
        DrinkCategoryFilter.GLASS.value,DrinkCategoryFilter.CATEGORY.value )
}

fun getAlcoholicValues(): MutableList<String>{
    return mutableListOf(ALCOHOLIC_Filter.ALCO.value,
        ALCOHOLIC_Filter.NONALCO.value,
        ALCOHOLIC_Filter.OPTIONAL.value)
}
fun getIngredientsValues(): MutableList<String>{
    return mutableListOf(INGREDIENTS_Filter.LIGHT_RUM.value,
        INGREDIENTS_Filter.APPLEJACK.value,
        INGREDIENTS_Filter.GIN.value)
}
fun getGlassValues(): MutableList<String>{
    return mutableListOf(GLASS_Filter.GLASS1.value,
        GLASS_Filter.GLASS2.value,
        GLASS_Filter.GLASS3.value)
}
fun getCategoryValues(): MutableList<String>{
    return mutableListOf(CATEGORY_Filter.CAT1.value,
        CATEGORY_Filter.CAT2.value,
        CATEGORY_Filter.CAT3.value)
}

enum class ALCOHOLIC_Filter(val value:String) {
    ALCO("Alcoholic"),
    NONALCO("Non alcoholic"),
    OPTIONAL("Optional alcohol")
}

enum class INGREDIENTS_Filter(val value:String) {
    LIGHT_RUM("Light rum"),
    APPLEJACK("Applejack"),
    GIN("Gin")
}

enum class GLASS_Filter(val value:String) {
    GLASS1("Highball glass"),
    GLASS2("Cocktail glass"),
    GLASS3("Old-fashioned_glass")
}

enum class CATEGORY_Filter(val value:String) {
    CAT1("Ordinary Drink"),
    CAT2("Cocktail"),
    CAT3("Milk / Float / Shake")
}



