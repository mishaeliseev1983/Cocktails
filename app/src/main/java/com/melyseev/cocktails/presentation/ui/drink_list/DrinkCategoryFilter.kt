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
    return mutableListOf(
        INGREDIENTS_Filter.INGREDIENT1.value, INGREDIENTS_Filter.INGREDIENT2.value, INGREDIENTS_Filter.INGREDIENT3.value,
        INGREDIENTS_Filter.INGREDIENT4.value, INGREDIENTS_Filter.INGREDIENT5.value, INGREDIENTS_Filter.INGREDIENT6.value,
        INGREDIENTS_Filter.INGREDIENT7.value, INGREDIENTS_Filter.INGREDIENT8.value, INGREDIENTS_Filter.INGREDIENT9.value,

        INGREDIENTS_Filter.INGREDIENT10.value,
        INGREDIENTS_Filter.INGREDIENT11.value, INGREDIENTS_Filter.INGREDIENT12.value, INGREDIENTS_Filter.INGREDIENT13.value,
        INGREDIENTS_Filter.INGREDIENT14.value, INGREDIENTS_Filter.INGREDIENT15.value, INGREDIENTS_Filter.INGREDIENT16.value,
        INGREDIENTS_Filter.INGREDIENT17.value, INGREDIENTS_Filter.INGREDIENT18.value, INGREDIENTS_Filter.INGREDIENT19.value,

        INGREDIENTS_Filter.INGREDIENT20.value,
        INGREDIENTS_Filter.INGREDIENT21.value, INGREDIENTS_Filter.INGREDIENT22.value, INGREDIENTS_Filter.INGREDIENT23.value,
        INGREDIENTS_Filter.INGREDIENT24.value, INGREDIENTS_Filter.INGREDIENT25.value, INGREDIENTS_Filter.INGREDIENT26.value,
        INGREDIENTS_Filter.INGREDIENT27.value, INGREDIENTS_Filter.INGREDIENT28.value, INGREDIENTS_Filter.INGREDIENT29.value,

        INGREDIENTS_Filter.INGREDIENT30.value,
        INGREDIENTS_Filter.INGREDIENT31.value, INGREDIENTS_Filter.INGREDIENT32.value, INGREDIENTS_Filter.INGREDIENT33.value,
        INGREDIENTS_Filter.INGREDIENT34.value, INGREDIENTS_Filter.INGREDIENT35.value, INGREDIENTS_Filter.INGREDIENT36.value,
        INGREDIENTS_Filter.INGREDIENT37.value, INGREDIENTS_Filter.INGREDIENT38.value, INGREDIENTS_Filter.INGREDIENT39.value,

        INGREDIENTS_Filter.INGREDIENT40.value,
        INGREDIENTS_Filter.INGREDIENT41.value, INGREDIENTS_Filter.INGREDIENT42.value, INGREDIENTS_Filter.INGREDIENT43.value,
        INGREDIENTS_Filter.INGREDIENT44.value, INGREDIENTS_Filter.INGREDIENT45.value, INGREDIENTS_Filter.INGREDIENT46.value,
        INGREDIENTS_Filter.INGREDIENT47.value, INGREDIENTS_Filter.INGREDIENT48.value, INGREDIENTS_Filter.INGREDIENT49.value,

        INGREDIENTS_Filter.INGREDIENT50.value,
        INGREDIENTS_Filter.INGREDIENT51.value, INGREDIENTS_Filter.INGREDIENT52.value, INGREDIENTS_Filter.INGREDIENT53.value,
        INGREDIENTS_Filter.INGREDIENT54.value, INGREDIENTS_Filter.INGREDIENT55.value, INGREDIENTS_Filter.INGREDIENT56.value,
        INGREDIENTS_Filter.INGREDIENT57.value, INGREDIENTS_Filter.INGREDIENT58.value, INGREDIENTS_Filter.INGREDIENT59.value,

        INGREDIENTS_Filter.INGREDIENT60.value,
        INGREDIENTS_Filter.INGREDIENT61.value, INGREDIENTS_Filter.INGREDIENT62.value, INGREDIENTS_Filter.INGREDIENT63.value,
        INGREDIENTS_Filter.INGREDIENT64.value, INGREDIENTS_Filter.INGREDIENT65.value, INGREDIENTS_Filter.INGREDIENT66.value,
        INGREDIENTS_Filter.INGREDIENT67.value, INGREDIENTS_Filter.INGREDIENT68.value, INGREDIENTS_Filter.INGREDIENT69.value,

        )
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
    INGREDIENT1("Light rum"), INGREDIENT2("Applejack"), INGREDIENT3("Gin"),
    INGREDIENT4("Dark rum"), INGREDIENT5("Sweet Vermouth"), INGREDIENT6("Strawberry schnapps"),
    INGREDIENT7("Scotch"), INGREDIENT8("Apricot brandy"), INGREDIENT9("Triple sec"),

    INGREDIENT10("Southern Comfort"),
    INGREDIENT11("Orange bitters"), INGREDIENT12("Brandy"), INGREDIENT13("Lemon vodka"),
    INGREDIENT14("Blended whiskey"), INGREDIENT15("Dry Vermouth"), INGREDIENT16("Amaretto"),
    INGREDIENT17("Tea"), INGREDIENT18("Champagne"), INGREDIENT19("Coffee liqueur"),

    INGREDIENT20( "Bourbon"),
    INGREDIENT21("Tequila"),INGREDIENT22("Vodka"), INGREDIENT23( "Añejo rum"),
    INGREDIENT24("Bitters"),INGREDIENT25("Sugar"), INGREDIENT26( "Kahlua"),
    INGREDIENT27("demerara Sugar"), INGREDIENT28( "Dubonnet Rouge"), INGREDIENT29("Watermelon"),


    INGREDIENT30( "Lime juice"),
    INGREDIENT31("Irish whiskey"),INGREDIENT32("Apple brandy"), INGREDIENT33( "Carbonated water"),
    INGREDIENT34("Cherry brandy"),INGREDIENT35("Creme de Cacao"), INGREDIENT36( "Grenadine"),
    INGREDIENT37("Port"), INGREDIENT38( "Coffee brandy"), INGREDIENT39("Red wine"),


    INGREDIENT40( "Rum"),
    INGREDIENT41("Grapefruit juice"),INGREDIENT42("Ricard"), INGREDIENT43( "Sherry"),
    INGREDIENT44("Cognac"),INGREDIENT45("Sloe gin"), INGREDIENT46( "Apple juice"),
    INGREDIENT47("Pineapple juice"), INGREDIENT48( "Lemon juice"), INGREDIENT49("Sugar syrup"),


    INGREDIENT50( "Milk"),
    INGREDIENT51("Strawberries"),INGREDIENT52("Chocolate syrup"), INGREDIENT53( "Yoghurt"),
    INGREDIENT54("Mango"),INGREDIENT55("Ginger"), INGREDIENT56( "Lime"),
    INGREDIENT57("Cantaloupe"), INGREDIENT58( "Berries"), INGREDIENT59("Grapes"),


    INGREDIENT60( "Kiwi"),
    INGREDIENT61("Tomato juice"),INGREDIENT62("Cocoa powder"), INGREDIENT63( "Chocolate"),
    INGREDIENT64("Ouzo"),INGREDIENT65("Coffee"), INGREDIENT66( "Spiced rum"),
    INGREDIENT67("Water"), INGREDIENT68( "Espresso"), INGREDIENT69("Angelica root"),
}

    enum class GLASS_Filter(val value:String) {
    GLASS1("Highball glass"), GLASS2("Cocktail glass"), GLASS3("Old-fashioned glass"),
    GLASS4("Whiskey Glass"), GLASS5("Collins glass"), GLASS6("Pousse cafe glass"),
    GLASS7("Champagne flute"), GLASS8("Whiskey sour glass"), GLASS9("Cordial glass"),
    GLASS10("Brandy snifter"), GLASS11("White wine glass"), GLASS12("Nick and Nora Glass"),
    GLASS13("Hurricane glass"), GLASS14("Coffee mug"), GLASS15("Shot glass"),
    GLASS16("Jar"), GLASS17("Irish coffee cup"), GLASS18("Punch bowl"), GLASS19("Pitcher"),
    GLASS20("Pint glass"), GLASS21("Copper Mug"), GLASS22("Wine Glass"),
    GLASS23("Beer mug"), GLASS24("Margarita/Coupette glass"), GLASS25("Beer pilsner"),
    GLASS26("Beer Glass"), GLASS27("Parfait glass"), GLASS28("Mason jar"),
    GLASS29("Margarita glass"), GLASS30("Martini Glass"), GLASS31("Balloon Glass"),
    GLASS32("Coupe Glass")
}

enum class CATEGORY_Filter(val value:String) {
    CAT1("Ordinary Drink"),
    CAT2("Cocktail"),
    CAT3("Milk / Float / Shake")
}



