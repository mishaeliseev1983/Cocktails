package com.melyseev.cocktails.interactors.drink_list

import android.util.Log

import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryDao
import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryEntity
import com.melyseev.cocktails.cache.model.drinkQuery.DrinkQueryEntityMapper
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortDao
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortEntityMapper
import com.melyseev.cocktails.domain.data.DataState
import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.network.RetrofitService
import com.melyseev.cocktails.network.model.drink_short.DrinkShortDtoMapper
import com.melyseev.cocktails.presentation.ui.drink_list.getAlcoholicValues
import com.melyseev.cocktails.presentation.ui.drink_list.getCategoryValues
import com.melyseev.cocktails.presentation.ui.drink_list.getGlassValues
import com.melyseev.cocktails.presentation.ui.drink_list.getIngredientsValues
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


const val TAG: String = "FilterDrinks"

class FilterDrinks(
    private val retrofitService: RetrofitService,
    private val drinkShortDtoMapper: DrinkShortDtoMapper,

    private val shortDao: DrinkShortDao,
    private val shortEntityMapper: DrinkShortEntityMapper,


    private val queryDao: DrinkQueryDao,
    private val queryEntityMapper: DrinkQueryEntityMapper,
){



    fun execute(query: String, isConnected: Boolean): Flow<DataState<List<DrinkShort>>> = flow {
        Log.d(TAG, " start  execute" )

        try {
            emit(DataState.loading<List<DrinkShort>>())
            Log.d(TAG, " start  execute_2" )

            var resultDrinks = mutableListOf<DrinkShort>()
            Log.d(TAG, " start  execute_3 isConnected $isConnected" )
            if(isConnected)
                 resultDrinks = ( getRecipesFromNetwork ( query ) ) as MutableList<DrinkShort>
            else {
                 //read
                 Log.d(TAG, " start  execute_4 read from db" )

                 val readIdDrinks = queryDao.getListIdDrinks(query1 = query)
                 val list = readIdDrinks?.split(",")
                 list?.let {
                     val listEntity = shortDao.getShortDrinksByIds( list )
                     println("size entity!! = " + listEntity.size)
                     resultDrinks= shortEntityMapper.fromEntityList(listEntity) as MutableList<DrinkShort>
                     }
            }

            if(resultDrinks.isNotEmpty() && isConnected) {


                //write
                val listEntity = shortEntityMapper.toEntityList(resultDrinks)
                shortDao.insertListDrinkShort(listEntity)
                //println(" write size = ${listEntity.size}" )

                //write query
                val listIdDrinksCommaSep =  getValueListIdDrinksSepComma(resultDrinks)
                if(listIdDrinksCommaSep.isNotEmpty()) {
                    val drinkQueryEntity = DrinkQueryEntity(
                            query,
                            listIdDrinks = listIdDrinksCommaSep
                    )
                    queryDao.insertDrinkQuery(drinkQueryEntity)
                    println( " write list  = ${listIdDrinksCommaSep}" )
                }
            }


            Log.d(TAG, " drinks size  ${resultDrinks.size}" )
            for(one_drink in resultDrinks){
                Log.d(TAG, " drink strDrink   ${one_drink.strDrink}" )
            }
            emit(DataState.success(resultDrinks as List<DrinkShort>))
        }catch (e: Exception){
            emit(DataState.error<List<DrinkShort>>(e.message?:"Unknown error"))
        }
    }


    fun getValueListIdDrinksSepComma(list: List<DrinkShort>): String{
        var result:  String =""
        for( one in list){
                result = result + one.idDrink + ","
        }
        return result
    }


    //this can throw exeption
    private suspend fun getRecipesFromNetwork(
        query: String
    ): List<DrinkShort> {
        //from the network
        Log.d(TAG,  "query = $query")

        for (value in getAlcoholicValues())
            if(query == value) {
                val recipesDtoResults = retrofitService.filterByAlcoholic(alco = query)
                return drinkShortDtoMapper.fromDomainList(recipesDtoResults.results)
            }

        for (value in getGlassValues())
            if(query == value) {
                val recipesDtoResults = retrofitService.filterByGlass(glass = query)
                return drinkShortDtoMapper.fromDomainList(recipesDtoResults.results)
            }

        for (value in getCategoryValues())
            if(query == value) {
                val recipesDtoResults = retrofitService.filterByCategory(category = query)
                return drinkShortDtoMapper.fromDomainList(recipesDtoResults.results)
            }

        for (value in getIngredientsValues())
            if(query == value) {
                val recipesDtoResults = retrofitService.filterByIngredient(ingredient = query)
                return drinkShortDtoMapper.fromDomainList(recipesDtoResults.results)
            }
        val recipesDtoResultsFirstLetter = retrofitService.searchByFirstLetter(firstLetter = query)
        return drinkShortDtoMapper.fromDomainList(recipesDtoResultsFirstLetter.results)

    }
}
