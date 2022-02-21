package com.melyseev.cocktails.presentation.ui.drink

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melyseev.cocktails.datastore.DataStoreApplication
import com.melyseev.cocktails.domain.model.DrinkFull
import com.melyseev.cocktails.interactors.drink.GetFullbyIdDrink
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DrinkFullViewModel
@Inject constructor(
    private val useCaseGetFullbyIdDrink: GetFullbyIdDrink,
    val dataStore: DataStoreApplication
): ViewModel() {

    var loading = mutableStateOf(false)
    var drinkFull: MutableState<DrinkFull?> = mutableStateOf(null)
    var errorLoading = mutableStateOf("")
    fun onTriggeredEvent(drinkFullEvent: DrinkFullEvent) {
        when (drinkFullEvent) {
            is DrinkFullEvent.GetDrinkFilterById -> {
                getDrinkFullById(drinkFullEvent.idDrink)
            }
        }
    }


    fun getDrinkFullById(idDrink: String) {

        Log.d(TAG, "get drink full by id ${idDrink}")
        useCaseGetFullbyIdDrink.execute(idDrink = idDrink).onEach { dataState ->
            loading.value = dataState.loading

            dataState.data?.let { fulldata ->
                drinkFull.value = dataState.data
            }

            dataState.error?.let { error ->
                Log.d(TAG, "lookup by id: $error")
                errorLoading.value = "No data"
             }
        }.launchIn(viewModelScope)
    }

}