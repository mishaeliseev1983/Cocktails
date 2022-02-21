package com.melyseev.cocktails.network.model.drink_full

import com.melyseev.cocktails.domain.model.DrinkFull
import com.melyseev.cocktails.domain.util.DomainMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkFullDtoMapper @Inject constructor(): DomainMapper<DrinkFullDto, DrinkFull> {
    override fun mapToDomain(drinkFulltDto: DrinkFullDto): DrinkFull {
        return  DrinkFull(
            idDrink = drinkFulltDto.idDrink,
            strDrink =  drinkFulltDto.strDrink,
            strDrinkThumb = drinkFulltDto.strDrinkThumb,
            strInstructions = drinkFulltDto.strInstructions,

            strIngredient1 = drinkFulltDto.strIngredient1,
            strIngredient2 = drinkFulltDto.strIngredient2,
            strIngredient3 = drinkFulltDto.strIngredient3,
            strIngredient4 = drinkFulltDto.strIngredient4,
            strIngredient5 = drinkFulltDto.strIngredient5,
            strIngredient6 = drinkFulltDto.strIngredient6,

            strIngredient7 = drinkFulltDto.strIngredient7,
            strIngredient8 = drinkFulltDto.strIngredient8,
            strIngredient9 = drinkFulltDto.strIngredient9,
            strIngredient10 = drinkFulltDto.strIngredient10,
            strIngredient11 = drinkFulltDto.strIngredient11,
            strIngredient12 = drinkFulltDto.strIngredient12,
            strIngredient13 = drinkFulltDto.strIngredient13,
            strIngredient14 = drinkFulltDto.strIngredient14,
            strIngredient15 = drinkFulltDto.strIngredient15,


            strMeasure1 = drinkFulltDto.strMeasure1,
            strMeasure2 = drinkFulltDto.strMeasure2,
            strMeasure3 = drinkFulltDto.strMeasure3,
            strMeasure4 = drinkFulltDto.strMeasure4,
            strMeasure5 = drinkFulltDto.strMeasure5,
            strMeasure6 = drinkFulltDto.strMeasure6,

            strMeasure7 = drinkFulltDto.strMeasure7,
            strMeasure8 = drinkFulltDto.strMeasure8,
            strMeasure9 = drinkFulltDto.strMeasure9,
            strMeasure10 = drinkFulltDto.strMeasure10,
            strMeasure11 = drinkFulltDto.strMeasure11,
            strMeasure12 = drinkFulltDto.strMeasure12,
            strMeasure13 = drinkFulltDto.strMeasure13,
            strMeasure14 = drinkFulltDto.strMeasure14,
            strMeasure15 = drinkFulltDto.strMeasure15,
            )
    }

    override fun mapFromDomain(domainModel: DrinkFull): DrinkFullDto {
        return DrinkFullDto(

            idDrink = domainModel.idDrink,
            strDrink = domainModel.strDrink,
            strDrinkThumb = domainModel.strDrinkThumb,
            strInstructions = domainModel.strInstructions,

            strIngredient1 = domainModel.strIngredient1,
            strIngredient2 = domainModel.strIngredient2,
            strIngredient3 = domainModel.strIngredient3,
            strIngredient4 = domainModel.strIngredient4,
            strIngredient5 = domainModel.strIngredient5,
            strIngredient6 = domainModel.strIngredient6,

            strIngredient7 = domainModel.strIngredient7,
            strIngredient8 = domainModel.strIngredient8,
            strIngredient9 = domainModel.strIngredient9,
            strIngredient10 = domainModel.strIngredient10,
            strIngredient11 = domainModel.strIngredient11,
            strIngredient12 = domainModel.strIngredient12,
            strIngredient13 = domainModel.strIngredient13,
            strIngredient14 = domainModel.strIngredient14,
            strIngredient15 = domainModel.strIngredient15,

            strMeasure1 = domainModel.strMeasure1,
            strMeasure2 = domainModel.strMeasure2,
            strMeasure3 = domainModel.strMeasure3,
            strMeasure4 = domainModel.strMeasure4,
            strMeasure5 = domainModel.strMeasure5,
            strMeasure6 = domainModel.strMeasure6,

            strMeasure7 = domainModel.strMeasure7,
            strMeasure8 = domainModel.strMeasure8,
            strMeasure9 = domainModel.strMeasure9,
            strMeasure10 = domainModel.strMeasure10,
            strMeasure11 = domainModel.strMeasure11,
            strMeasure12 = domainModel.strMeasure12,
            strMeasure13 = domainModel.strMeasure13,
            strMeasure14 = domainModel.strMeasure14,
            strMeasure15 = domainModel.strMeasure15,
            )
    }
/*
    fun fromDomainList(initial: List<DrinkFullDto>): List<DrinkFull>{
        return initial.map { mapToDomain(it) }
    }

    fun toDomainList(initial: List<DrinkFull>): List<DrinkFullDto>{
        return initial.map { mapFromDomain(it) }
    }

 */
}