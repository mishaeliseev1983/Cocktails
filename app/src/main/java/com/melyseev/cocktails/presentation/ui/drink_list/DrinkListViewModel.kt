package com.melyseev.cocktails.presentation.ui.drink_list

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melyseev.cocktails.datastore.DataStoreApplication
import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.interactors.drink_list.FilterDrinks
import com.melyseev.cocktails.network_status.ConnectivityManagerNetworkAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "DrinkListViewModel"

@HiltViewModel
class DrinkListViewModel
@Inject constructor(private val filterDrinks: FilterDrinks,
                    val dataStore: DataStoreApplication,
                    val connectivityManager: ConnectivityManagerNetworkAvailable
                    ):ViewModel(){

    var categoryScrollPosition: Int = -1
    //var selectedListValueCategory=mutableStateOf("Alcoholic")

    var loaded =  mutableStateOf(false)
    //val localIsConnected = mutableStateOf(true)
    val drinks: MutableState<List<DrinkShort>> = mutableStateOf(listOf())
    var query = mutableStateOf("")
    var loading = mutableStateOf(false)
    var errorLoading = mutableStateOf("")

    private var filterAlcoholic = mutableStateOf(false)
    private var filterIngredients = mutableStateOf(false)
    private var filterGlass = mutableStateOf(false)
    private var filterCategory = mutableStateOf(false)


    fun filterAlcoholicDrinks(){

        resetSearchState()
        Log.d(TAG, "new filter query ${query.value}")
        println("localIsConnected.value = ${connectivityManager.isNetworkAvailable.value}")
        filterDrinks.execute(query = query.value, isConnected = connectivityManager.isNetworkAvailable.value/*connectivityManager.isNetworkAvailable.value*/).onEach {
            dataState ->
            loading.value = dataState.loading

            //loaded.value = false
            println("localIsConnected.value = ${connectivityManager.isNetworkAvailable.value}")
            //if(dataState.data == null){
            //    println("new data set is null")
            //}
            dataState.data?.let {
                    println("new data set! size list ${it.size}")
                    drinks.value = it
                    loaded.value = true
            }
            dataState.error?.let {
                    error -> Log.d(TAG, "filter: $error")
                errorLoading.value = error
                loaded.value = true
            }

        }.launchIn(viewModelScope)
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

        Log.e(TAG, "onQueryChange: newer = $newer")
        query.value = newer
    }

    fun onSelectedValueCategoryChanged(newValueListCategory: String){

        println("  = onSelectedValueCategoryChanged= $newValueListCategory" )

        categoryScrollPosition = -1
        dataStore.valueCategory.value = newValueListCategory
        onQueryChange(newValueListCategory)
    }

    /**
     * Called when a new search is executed.
     */
    private fun resetSearchState() {

        println("resetSearchState------------")
        drinks.value = listOf()
        errorLoading.value= ""
        //onChangeRecipeScrollPosition(0)
        if (dataStore.valueCategory.value != query.value) clearSelectedCategory()
    }

    private fun clearSelectedCategory() {
        dataStore.valueCategory.value = ""
    }

    fun updateViewWithNewCategory(){
        val oldCategory = dataStore.category.value
        if(!filterAlcoholic.value && !filterIngredients.value && !filterGlass.value && !filterCategory.value) {
            dataStore.category.value = ""
        }

        if(filterAlcoholic.value)
                dataStore.category.value = DrinkCategoryFilter.ALCOHOLIC.value
        if(filterIngredients.value)
            dataStore.category.value = DrinkCategoryFilter.INGREDIENTS.value
        if(filterGlass.value)
            dataStore.category.value = DrinkCategoryFilter.GLASS.value
        if(filterCategory.value)
            dataStore.category.value = DrinkCategoryFilter.CATEGORY.value

        if(oldCategory == dataStore.category.value)
                                return

        val valuesCategory = getValuesByCurrentCategory(dataStore.category.value)


        var newValue = ""
        if(valuesCategory.isNotEmpty()) {
            newValue = valuesCategory[0]
            dataStore.valueCategory.value = newValue
            query.value = newValue
            categoryScrollPosition = 0

            println("new! newValue $newValue")
            println("new! dataStore.category.value ${dataStore.category.value}")
            println("new! categoryScrollPosition $categoryScrollPosition")
        }else {
            dataStore.valueCategory.value = ""
            //query.value = ""
        }
    }

    fun onChangedCheckedFilter(newCategory: String) {

        //query.value = "Non alcoholic"
        when (newCategory) {
            DrinkCategoryFilter.ALCOHOLIC.value -> {
                filterAlcoholic.value = !filterAlcoholic.value
                filterIngredients.value = false
                filterGlass.value = false
                filterCategory.value = false
            }
            DrinkCategoryFilter.INGREDIENTS.value -> {
                filterAlcoholic.value = false
                filterIngredients.value = !filterIngredients.value
                filterGlass.value = false
                filterCategory.value = false
            }
            DrinkCategoryFilter.GLASS.value -> {
                filterAlcoholic.value = false
                filterIngredients.value = false
                filterGlass.value = !filterGlass.value
                filterCategory.value = false
            }
            DrinkCategoryFilter.CATEGORY.value -> {
                filterAlcoholic.value = false
                filterIngredients.value = false
                filterGlass.value = false
                filterCategory.value = !filterCategory.value
            }

            else -> { // Note the block
                print("$newCategory unknown !")
            }

        }

        /*
        dataStore.category.value = newCategory
        if(!filterAlcoholic.value && !filterIngredients.value && !filterGlass.value && !filterCategory.value)
           updateViewWithNewCategory(newCategory = "")
        else
           updateViewWithNewCategory(newCategory = newCategory)


         */



    }




        fun setCheckedStates(){
           when(dataStore.category.value){
                DrinkCategoryFilter.ALCOHOLIC.value     -> filterAlcoholic.value = true
                DrinkCategoryFilter.INGREDIENTS.value   -> filterIngredients.value = true
                DrinkCategoryFilter.CATEGORY.value      -> filterCategory.value = true
                DrinkCategoryFilter.GLASS.value         -> filterGlass.value = true
            }
        }

        fun getCheckedStateByValue(category: String) =
            when(category){
                DrinkCategoryFilter.ALCOHOLIC.value     -> filterAlcoholic.value
                DrinkCategoryFilter.INGREDIENTS.value   -> filterIngredients.value
                DrinkCategoryFilter.CATEGORY.value      -> filterCategory.value
                DrinkCategoryFilter.GLASS.value         -> filterGlass.value
                else -> false
            }


    override fun onCleared() {
        dataStore.saveQueryCommmaCategory("${query.value}, ${dataStore.category.value}")
        super.onCleared()
    }



}