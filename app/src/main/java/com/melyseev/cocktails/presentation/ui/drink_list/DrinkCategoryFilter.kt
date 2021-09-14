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
    return mutableListOf(
        GLASS_Filter.GLASS1.value, GLASS_Filter.GLASS2.value, GLASS_Filter.GLASS3.value,
        GLASS_Filter.GLASS4.value, GLASS_Filter.GLASS5.value, GLASS_Filter.GLASS6.value,
        GLASS_Filter.GLASS7.value, GLASS_Filter.GLASS8.value, GLASS_Filter.GLASS9.value,
        GLASS_Filter.GLASS10.value, GLASS_Filter.GLASS11.value, GLASS_Filter.GLASS12.value,
        GLASS_Filter.GLASS13.value, GLASS_Filter.GLASS14.value, GLASS_Filter.GLASS15.value,
        GLASS_Filter.GLASS16.value, GLASS_Filter.GLASS17.value, GLASS_Filter.GLASS18.value,
        GLASS_Filter.GLASS19.value, GLASS_Filter.GLASS20.value, GLASS_Filter.GLASS21.value,
        GLASS_Filter.GLASS22.value, GLASS_Filter.GLASS23.value, GLASS_Filter.GLASS24.value,
        GLASS_Filter.GLASS25.value, GLASS_Filter.GLASS26.value, GLASS_Filter.GLASS27.value,
        GLASS_Filter.GLASS28.value, GLASS_Filter.GLASS29.value, GLASS_Filter.GLASS30.value,
        GLASS_Filter.GLASS31.value, GLASS_Filter.GLASS32.value
        )
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
    GLASS3("Old-fashioned glass"),
    GLASS4("Whiskey Glass"),
    GLASS5("Collins glass"),
    GLASS6("Pousse cafe glass"),
    GLASS7("Champagne flute"),
    GLASS8("Whiskey sour glass"),
    GLASS9("Cordial glass"),
    GLASS10("Brandy snifter"),
    GLASS11("White wine glass"),
    GLASS12("Nick and Nora Glass"),
    GLASS13("Hurricane glass"),
    GLASS14("Coffee mug"),
    GLASS15("Shot glass"),
    GLASS16("Jar"),
    GLASS17("Irish coffee cup"),
    GLASS18("Punch bowl"),
    GLASS19("Pitcher"),
    GLASS20("Pint glass"),
    GLASS21("Copper Mug"),
    GLASS22("Wine Glass"),
    GLASS23("Beer mug"),
    GLASS24("Margarita/Coupette glass"),
    GLASS25("Beer pilsner"),
    GLASS26("Beer Glass"),
    GLASS27("Parfait glass"),
    GLASS28("Mason jar"),
    GLASS29("Margarita glass"),
    GLASS30("Martini Glass"),
    GLASS31("Balloon Glass"),
    GLASS32("Coupe Glass")

}

enum class CATEGORY_Filter(val value:String) {
    CAT1("Ordinary Drink"),
    CAT2("Cocktail"),
    CAT3("Milk / Float / Shake")
}



