package com.melyseev.cocktails.network.model.drink_full

import com.melyseev.cocktails.domain.model.DrinkFull
import com.melyseev.cocktails.domain.util.DomainMapper

class DrinkFullDtoMapper: DomainMapper<DrinkFullDto, DrinkFull> {
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

            strMeasure1 = drinkFulltDto.strMeasure1,
            strMeasure2 = drinkFulltDto.strMeasure2,
            strMeasure3 = drinkFulltDto.strMeasure3,
            strMeasure4 = drinkFulltDto.strMeasure4,
            strMeasure5 = drinkFulltDto.strMeasure5,
            strMeasure6 = drinkFulltDto.strMeasure6,
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

            strMeasure1 = domainModel.strMeasure1,
            strMeasure2 = domainModel.strMeasure2,
            strMeasure3 = domainModel.strMeasure3,
            strMeasure4 = domainModel.strMeasure4,
            strMeasure5 = domainModel.strMeasure5,
            strMeasure6 = domainModel.strMeasure6,
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