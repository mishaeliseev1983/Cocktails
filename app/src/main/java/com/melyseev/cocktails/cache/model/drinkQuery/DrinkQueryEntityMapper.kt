package com.melyseev.cocktails.cache.model.drinkQuery

import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortEntity
import com.melyseev.cocktails.domain.model.DrinkQuery
import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.domain.util.DomainMapper
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkQueryEntityMapper @Inject constructor(): DomainMapper<DrinkQueryEntity, DrinkQuery> {

    override fun mapToDomain(drinkQueryEntity: DrinkQueryEntity): DrinkQuery {

        return DrinkQuery(
            listIdDrinks = drinkQueryEntity.listIdDrinks,
            query = drinkQueryEntity.query
        )
    }

    override fun mapFromDomain(domainModel: DrinkQuery): DrinkQueryEntity {
        return DrinkQueryEntity(
            listIdDrinks = domainModel.listIdDrinks,
            query = domainModel.query
        )
    }

}