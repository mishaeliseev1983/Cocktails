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
@Inject constructor(private val filterDrinks: FilterDrinks,
                    val connectivityManager: ConnectivityManagerNetworkAvailable,
                    val drinkCategoryValues: DrinkCategoryValues
                    ):ViewModel(){
    val drinks: MutableState<List<DrinkShort>> = mutableStateOf(listOf())
    var query = mutableStateOf("")
    var categoryScrollPosition: Int = -1
    var loading = mutableStateOf(false)
    val selectedCategory = mutableStateOf("")


    var filterAlcoholic = mutableStateOf(true)
    var filterIngredients = mutableStateOf(false)
    var filterGlass = mutableStateOf(false)
    var filterCategory = mutableStateOf(false)

    init {

        query.value = drinkCategoryValues.currentCategory
        selectedCategory.value = drinkCategoryValues.currentCategory
        onTriggerEvent(DrinkListEvent.NewFilterAlcoholicEvent)
    }

    fun filterAlcoholicDrinks(){

        resetSearchState()
        Log.d(TAG, "new filter query ${query.value}")
        filterDrinks.execute(query = query.value).onEach {
            dataState ->
            loading.value = dataState.loading

            if(dataState.data == null){
                println("new data set is null")
            }
            dataState.data?.let {
                    println("new data set! size list ${it.size}")
                    drinks.value = it
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

    fun onSelectedCategoryChanged(newCategory: String){
        //val newCategory= getDrinkCategory(category)
        selectedCategory.value =newCategory
        onQueryChange(newCategory)
    }

    fun onChangeCategoryScrollPosition(position: Int) {
        categoryScrollPosition  = position
    }

    /**
     * Called when a new search is executed.
     */
    private fun resetSearchState() {
        drinks.value = listOf()
        //onChangeRecipeScrollPosition(0)
        if (selectedCategory.value != query.value) clearSelectedCategory()
    }

    private fun clearSelectedCategory() {
        selectedCategory.value = ""
    }


    fun updateViewWithNewCategory(newCategory: String){
        drinkCategoryValues.currentCategory = newCategory
        selectedCategory.value = drinkCategoryValues.getValuesByCurrentCategory()[0]
        query.value = selectedCategory.value
        //onTriggerEvent(DrinkListEvent.NewFilterAlcoholicEvent)
    }

    fun onChangedCheckedFilter(newCategory: String) {

        drinkCategoryValues.currentCategory = ""
        when (newCategory) {
            "a" -> {
                filterAlcoholic.value = !filterAlcoholic.value
                filterIngredients.value = false
                filterGlass.value = false
                filterCategory.value = false
                if(filterAlcoholic.value)
                    updateViewWithNewCategory("Alcoholic")
            }
            "i" -> {
                filterAlcoholic.value = false
                filterIngredients.value = !filterIngredients.value
                filterGlass.value = false
                filterCategory.value = false
                if(filterIngredients.value)
                    updateViewWithNewCategory("Ingredients")
                    /*drinkCategoryValues.currentCategory = "Ingredients"
                    selectedCategory.value = drinkCategoryValues.getValuesByCurrentCategory()[0]
                    query.value = selectedCategory.value
                    onTriggerEvent(DrinkListEvent.NewFilterAlcoholicEvent)*/
            }
            "g" -> {
                filterAlcoholic.value = false
                filterIngredients.value = false
                filterGlass.value = !filterGlass.value
                filterCategory.value = false
                if(filterGlass.value)
                    updateViewWithNewCategory("Glass")
            }
            "c" -> {
                filterAlcoholic.value = false
                filterIngredients.value = false
                filterGlass.value = false
                filterCategory.value = !filterCategory.value
                if(filterCategory.value)
                   updateViewWithNewCategory("Category")
            }

            else -> { // Note the block
                print("$newCategory unknown !")
            }
        }
    }

        fun getCheckedStateByValue(category: String): Boolean {

            if(category=="a") return  filterAlcoholic.value
            if(category=="i") return  filterIngredients.value
            if(category=="g") return  filterGlass.value
            if(category=="c") return  filterCategory.value
            return false
        }




}