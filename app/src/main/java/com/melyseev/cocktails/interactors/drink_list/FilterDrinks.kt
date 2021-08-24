package com.melyseev.cocktails.interactors.drink_list

import android.util.Log
import com.melyseev.cocktails.domain.data.DataState
import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.network.RetrofitService
import com.melyseev.cocktails.network.model.DrinkShortDtoMapper
import com.melyseev.cocktails.network.response.DrinkFilterResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

const val TAG: String = "FilterDrinks"

class FilterDrinks(
    private val retrofitService: RetrofitService,
    private val drinkShortDtoMapper: DrinkShortDtoMapper,
){



    fun execute(query: String): Flow<DataState<List<DrinkShort>>> = flow {
        Log.d(TAG, " start  execute" )
        try {
            emit(DataState.loading<List<DrinkShort>>())
            Log.d(TAG, " start  execute_2" )
            delay(1_000)
            Log.d(TAG, " start  execute_3" )
            val drinks : List<DrinkShort> =getRecipesFromNetwork ( query )
            Log.d(TAG, " drinks size  ${drinks.size}" )
            for(one_drink in drinks){
                Log.d(TAG, " drink strDrink   ${one_drink.strDrink}" )
            }
            emit(DataState.success(drinks))
        }catch (e: Exception){
            emit(DataState.error<List<DrinkShort>>(e.message?:"Unknown error"))
        }
    }

    //this can throw exeption
    private suspend fun getRecipesFromNetwork(
        query: String
    ):List<DrinkShort>{
        //from the network
        Log.d(TAG,  "query = $query")
        val recipesDtoResults: DrinkFilterResponse =  retrofitService.filter( query = query )
        return  drinkShortDtoMapper.fromDomainList(recipesDtoResults.results)
    }
}
