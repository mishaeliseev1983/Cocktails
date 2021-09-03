package com.melyseev.cocktails.network.model.drink_full

import com.melyseev.cocktails.domain.model.DrinkFull
import com.melyseev.cocktails.domain.util.DomainMapper

class DrinkFullDtoMapper: DomainMapper<DrinkFullDto, DrinkFull> {
    override fun mapToDomain(drinkFulltDto: DrinkFullDto): DrinkFull {
        return  DrinkFull(
            idDrink = drinkFulltDto.idDrink,
            strDrink =  drinkFulltDto.strDrink,
            strDrinkThumb = drinkFulltDto.strDrinkThumb,
            strInstructions = drinkFulltDto.strInstructions
            )
    }

    override fun mapFromDomain(domainModel: DrinkFull): DrinkFullDto {
        return DrinkFullDto(

            idDrink = domainModel.idDrink,
            strDrink = domainModel.strDrink,
            strDrinkThumb = domainModel.strDrinkThumb,
            strInstructions = domainModel.strInstructions
            )
    }

    fun fromDomainList(initial: List<DrinkFullDto>): List<DrinkFull>{
        return initial.map { mapToDomain(it) }
    }

    fun toDomainList(initial: List<DrinkFull>): List<DrinkFullDto>{
        return initial.map { mapFromDomain(it) }
    }
}