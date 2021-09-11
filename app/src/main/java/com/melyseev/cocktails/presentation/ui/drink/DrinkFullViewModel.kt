package com.melyseev.cocktails.presentation.ui.drink

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melyseev.cocktails.domain.data.DataState
import com.melyseev.cocktails.domain.model.DrinkFull
import com.melyseev.cocktails.interactors.drink.GetFullbyIdDrink
import com.melyseev.cocktails.presentation.util.ConnectivityManagerNetworkAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DrinkFullViewModel
@Inject constructor(
    private val useCaseGetFullbyIdDrink: GetFullbyIdDrink,
    val connectivityManager: ConnectivityManagerNetworkAvailable
): ViewModel() {

    var loading = mutableStateOf(false)
    var drinkFull: MutableState<DrinkFull?> = mutableStateOf(null)


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
            }
        }.launchIn(viewModelScope)
    }
}