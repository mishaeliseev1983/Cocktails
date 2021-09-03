package com.melyseev.cocktails.interactors.drink

import android.util.Log
import com.melyseev.cocktails.domain.data.DataState
import com.melyseev.cocktails.domain.model.DrinkFull
import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.interactors.drink_list.TAG
import com.melyseev.cocktails.network.RetrofitService
import com.melyseev.cocktails.network.model.drink_full.DrinkFullDtoMapper
import com.melyseev.cocktails.network.response.DrinkFullbyIdResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFullbyIdDrink(
    private val retrofitService: RetrofitService,
    private val drinkFullDtoMapper: DrinkFullDtoMapper
) {

    fun execute(idDrink: String): Flow<DataState<DrinkFull>> = flow {
        Log.d(TAG, " start  execute" )
        try {
            emit(DataState.loading())
            Log.d(TAG, " start  drink full 1 " )
            delay(1_000)
            Log.d(TAG, " start  drink full 2" )

            val result: DrinkFull =  getDrinkFullbyIdFromNetwork(idDrink = idDrink)
            emit(DataState.success(result))
        }catch (e: Exception){
            emit(DataState.error<DrinkFull>(e.message?:"Unknown error"))
        }
    }

    //this can throw exeption
    private suspend fun getDrinkFullbyIdFromNetwork(
        idDrink: String
    ):DrinkFull{
        //from the network
        Log.d(TAG,  "idDrink = $idDrink")
        val drinkResults : DrinkFullbyIdResponse =  retrofitService.lookupById( idDrink = idDrink )
        val drinkFullDto = drinkResults.result[0]
        return  drinkFullDtoMapper.mapToDomain(drinkFullDto)
    }
}