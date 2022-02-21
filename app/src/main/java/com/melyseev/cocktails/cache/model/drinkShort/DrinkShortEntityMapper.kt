package com.melyseev.cocktails.cache.model.drinkShort

import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.domain.util.DomainMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkShortEntityMapper @Inject constructor(): DomainMapper<DrinkShortEntity, DrinkShort> {

    override fun mapToDomain(drinkShortEntity: DrinkShortEntity): DrinkShort {
        return DrinkShort(
            idDrink = drinkShortEntity.idDrink,
            strDrink = drinkShortEntity.strDrink,
            strDrinkThumb = drinkShortEntity.strDrinkThumb
        )
    }

    override fun mapFromDomain(domainModel: DrinkShort): DrinkShortEntity {
        return DrinkShortEntity(
            idDrink = domainModel.idDrink,
            strDrink = domainModel.strDrink,
            strDrinkThumb = domainModel.strDrinkThumb
        )
    }


    fun fromEntityList(initial: List<DrinkShortEntity>): List<DrinkShort>{
        initial.sortedBy { it.idDrink }
        return initial.map { mapToDomain(it) }
    }

    fun toEntityList(initial: List<DrinkShort>): List<DrinkShortEntity>{
        initial.sortedBy { it.idDrink }
        return initial.map { mapFromDomain(it) }
    }


}