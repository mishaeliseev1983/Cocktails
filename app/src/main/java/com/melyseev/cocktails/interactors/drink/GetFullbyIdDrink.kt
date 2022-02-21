package com.melyseev.cocktails.interactors.drink

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.melyseev.cocktails.cache.model.drinkFull.DrinkFullDao
import com.melyseev.cocktails.cache.model.drinkFull.DrinkFullEntityMapper
import com.melyseev.cocktails.cache.model.drinkShort.DrinkShortEntityMapper
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
    private val drinkFullDtoMapper: DrinkFullDtoMapper,
    private val fullDao: DrinkFullDao,
    private val fullEntityMapper: DrinkFullEntityMapper,
    ) {

    fun execute(idDrink: String): Flow<DataState<DrinkFull>> = flow {
        Log.d(TAG, " start  execute" )
        try {
            emit(DataState.loading())


            var result : DrinkFull
            //read
            Log.d(TAG, " reading from database" )
            val fullEntity = fullDao.getFullDrinkById(idDrinkOne = idDrink)
            if(fullEntity!=null){
                result = fullEntityMapper.mapToDomain(fullEntity)
            }else
            {
                Log.d(TAG, " reading from Network" )
                result = getDrinkFullbyIdFromNetwork(idDrink = idDrink)

                //write
                val fullEntity = fullEntityMapper.mapFromDomain(result)
                fullDao.insertDrinkFull(fullEntity)
            }
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