package com.melyseev.cocktails.network.model

import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.domain.util.DomainMapper

class DrinkShortDtoMapper: DomainMapper<DrinkShortDto, DrinkShort> {
    override fun mapToDomain(drinkShortDto: DrinkShortDto): DrinkShort {
        return  DrinkShort( drinkShortDto.idDink,
            drinkShortDto.strDrink,
            drinkShortDto.strDrinkThumb
        )
    }

    override fun mapFromDomain(domainModel: DrinkShort): DrinkShortDto {
        TODO("Not yet implemented")
    }

    fun fromDomainList(initial: List<DrinkShortDto>): List<DrinkShort>{
        return initial.map { mapToDomain(it) }
    }

    fun toDomainList(initial: List<DrinkShort>): List<DrinkShortDto>{
        return initial.map { mapFromDomain(it) }
    }
}