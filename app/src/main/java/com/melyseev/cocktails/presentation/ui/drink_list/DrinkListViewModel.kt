package com.melyseev.cocktails.presentation.ui.drink_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.interactors.drink_list.FilterDrinks
import com.melyseev.cocktails.presentation.util.ConnectivityManagerNetworkAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

const val TAG = "DrinkListViewModel"

@HiltViewModel
class DrinkListViewModel
//@Inject constructor(private val filterDrinks: FilterDrinks): ViewModel() {
@Inject constructor(private val filterDrinks: FilterDrinks,
                    val connectivityManager: ConnectivityManagerNetworkAvailable
                    ):ViewModel(){
    val drinks: MutableState<List<DrinkShort>> = mutableStateOf(listOf())
    val query = mutableStateOf("Alcoholic")
    var categoryScrollPosition: Int = -1
    var loading = mutableStateOf(false)
    val selectedCategory:MutableState<DrinkCategory?> = mutableStateOf(null)

    init {
        onTriggerEvent(DrinkListEvent.NewFilterAlcoholicEvent)
    }

    fun filterAlcoholicDrinks(){

        Log.d(TAG, "new filter query ${query.value}")
        filterDrinks.execute(query = query.value).onEach {
            dataState ->
            loading.value = dataState.loading

            dataState.data?.let {
                    list -> drinks.value = list
            }
            dataState.error?.let {
                    error -> Log.d(TAG, "filter: $error")
            }
        }.launchIn(viewModelScope)

                /*
            .onEach{
                    dataState ->
                loading = dataState.loading


                dataState.data?.let {
                        list -> drinks.value = list
                }
                dataState.error?.let {
                        error -> Log.d(TAG, "filter: $error")
                }
            }.launchIn(viewModelScope)

                 */
    }

    fun onTriggerEvent(event: DrinkListEvent) {
        Log.w(TAG, "onTriggerEvent!!!: ")
        try {
            when (event) {
                is DrinkListEvent.NewFilterAlcoholicEvent -> {
                   filterAlcoholicDrinks()
                }
            }

        } catch (e: Exception) {
            Log.e(TAG, "onTriggerEvent: Exception: ${e}, ${e.cause}")
        }
    }

    fun onQueryChange(newer: String) {
        query.value = newer
    }

    fun onSelectedCategoryChanged(category: String){
        val newCategory= getDrinkCategory(category)
        selectedCategory.value =newCategory
        onQueryChange(category)
    }

    fun onChangeCategoryScrollPosition(position: Int) {
        categoryScrollPosition  = position
    }

}