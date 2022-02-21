package com.melyseev.cocktails.cache.model.drinkFull

import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryEntity
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortEntity
import com.melyseev.cocktails.domain.model.DrinkFull
import com.melyseev.cocktails.domain.model.DrinkQuery
import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.domain.util.DomainMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkFullEntityMapper @Inject constructor(): DomainMapper<DrinkFullEntity, DrinkFull> {

    override fun mapToDomain(drinkFullEntity: DrinkFullEntity): DrinkFull {
        return DrinkFull(
            idDrink = drinkFullEntity.idDrink,
            strDrink = drinkFullEntity.strDrink,
            strDrinkThumb = drinkFullEntity.strDrinkThumb,

            strInstructions = drinkFullEntity.strInstructions,

            strIngredient1 = drinkFullEntity.strIngredient1,
            strIngredient2 = drinkFullEntity.strIngredient2,
            strIngredient3 = drinkFullEntity.strIngredient3,
            strIngredient4 = drinkFullEntity.strIngredient4,
            strIngredient5 = drinkFullEntity.strIngredient5,
            strIngredient6 = drinkFullEntity.strIngredient6,
            strIngredient7 = drinkFullEntity.strIngredient7,
            strIngredient8 = drinkFullEntity.strIngredient8,
            strIngredient9 = drinkFullEntity.strIngredient9,
            strIngredient10 = drinkFullEntity.strIngredient10,
            strIngredient11 = drinkFullEntity.strIngredient11,
            strIngredient12 = drinkFullEntity.strIngredient12,
            strIngredient13 = drinkFullEntity.strIngredient13,
            strIngredient14 = drinkFullEntity.strIngredient14,
            strIngredient15 = drinkFullEntity.strIngredient15,

            strMeasure1 = drinkFullEntity.strMeasure1,
            strMeasure2 = drinkFullEntity.strMeasure2,
            strMeasure3 = drinkFullEntity.strMeasure3,
            strMeasure4 = drinkFullEntity.strMeasure4,
            strMeasure5 = drinkFullEntity.strMeasure5,
            strMeasure6 = drinkFullEntity.strMeasure6,
            strMeasure7 = drinkFullEntity.strMeasure7,
            strMeasure8 = drinkFullEntity.strMeasure8,
            strMeasure9 = drinkFullEntity.strMeasure9,
            strMeasure10 = drinkFullEntity.strMeasure10,
            strMeasure11 = drinkFullEntity.strMeasure11,
            strMeasure12 = drinkFullEntity.strMeasure12,
            strMeasure13 = drinkFullEntity.strMeasure13,
            strMeasure14 = drinkFullEntity.strMeasure14,
            strMeasure15 = drinkFullEntity.strMeasure15,

        )
    }

    override fun mapFromDomain(domainModel: DrinkFull): DrinkFullEntity {
        return DrinkFullEntity(
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


    fun fromEntityList(initial: List<DrinkFullEntity>): List<DrinkFull>{
        return initial.map { mapToDomain(it) }
    }

    fun toEntityList(initial: List<DrinkFull>): List<DrinkFullEntity>{
        return initial.map { mapFromDomain(it) }
    }


}