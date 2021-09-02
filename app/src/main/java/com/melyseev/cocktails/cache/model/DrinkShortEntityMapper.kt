package com.melyseev.cocktails.cache.model

import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.domain.util.DomainMapper

class DrinkShortEntityMapper: DomainMapper<DrinkShortEntity, DrinkShort> {

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

}