package com.melyseev.cocktails.network.model.drink_short

import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.domain.util.DomainMapper

class DrinkShortDtoMapper: DomainMapper<DrinkShortDto, DrinkShort> {
    override fun mapToDomain(drinkShortDto: DrinkShortDto): DrinkShort {
        return  DrinkShort(
                idDrink = drinkShortDto.idDrink,
                strDrink =  drinkShortDto.strDrink,
                strDrinkThumb = drinkShortDto.strDrinkThumb
        )
    }

    override fun mapFromDomain(domainModel: DrinkShort): DrinkShortDto {
        return DrinkShortDto(
            idDrink = domainModel.idDrink,
            strDrink = domainModel.strDrink,
            strDrinkThumb = domainModel.strDrinkThumb
        )
    }

    fun fromDomainList(initial: List<DrinkShortDto>): List<DrinkShort>{
        return initial.map { mapToDomain(it) }
    }

    fun toDomainList(initial: List<DrinkShort>): List<DrinkShortDto>{
        return initial.map { mapFromDomain(it) }
    }
}