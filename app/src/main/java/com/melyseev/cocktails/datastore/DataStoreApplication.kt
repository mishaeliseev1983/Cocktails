package com.melyseev.cocktails.datastore

import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.melyseev.cocktails.BaseApplication
import com.melyseev.cocktails.presentation.ui.drink_list.DrinkCategoryFilter

import com.melyseev.cocktails.presentation.ui.drink_list.INGREDIENTS_Filter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

const val IS_DARK_THEME_CONST = "is_dark_theme"
const val QUERY_COMMA_CATEGORY_CONST = "query_comma_category"
const val NO_VALUE_CONST = "no_value"

@Singleton
class DataStoreApplication  @Inject constructor(    val baseApplication: BaseApplication ) {
    private val scope = CoroutineScope(Dispatchers.IO)
    val BaseApplication.prefsDataStore: DataStore<Preferences>  by preferencesDataStore( name = "pref3")


    val category = mutableStateOf(NO_VALUE_CONST)
    val valueCategory = mutableStateOf(NO_VALUE_CONST)

    init {
         observeDataStore()
    }

    companion object{
        val IS_DARK_THEME = booleanPreferencesKey(IS_DARK_THEME_CONST)
        val QUERY_COMMA_CATEGORY = stringPreferencesKey(QUERY_COMMA_CATEGORY_CONST)
    }

    val isDark = mutableStateOf(false)

    fun toggleTheme(){
        scope.launch {

            baseApplication.prefsDataStore.edit {
                    preferences ->
                val current = preferences[IS_DARK_THEME]?:false
                preferences[IS_DARK_THEME] = !current
            }
        }
    }



    fun saveQueryCommmaCategory(newValue: String){
        scope.launch {
            baseApplication.prefsDataStore.edit { preferences ->
                preferences[QUERY_COMMA_CATEGORY] = newValue
            }
        }
    }


    private fun observeDataStore() {

        baseApplication.prefsDataStore.data.onEach { preferences ->
            val res1 = INGREDIENTS_Filter.INGREDIENT67.value
            val res2 = DrinkCategoryFilter.INGREDIENTS.value
            preferences[QUERY_COMMA_CATEGORY]?.let{

               val twoString = getListResult(it)
                when(twoString.size){
                    0-> {
                        valueCategory.value = res1
                        category.value = res2
                    }
                    1->{
                        valueCategory.value= twoString[0]
                        category.value = ""
                    }
                    2-> {
                        valueCategory.value = twoString[0]
                        category.value = twoString[1]
                    }
                }
            }?: run{
                valueCategory.value = res1
                category.value = res2
            }

            preferences[IS_DARK_THEME]?.let{
                    isDarkTheme->
                        isDark.value = isDarkTheme
            }



        }.launchIn(scope = scope)
    }


    private fun getListResult(str: String): List<String> {

        val result = mutableListOf<String>()
        val arrSplit = str.split(",")
        for(one in arrSplit){
            val str= one.trim()
            if(str.isNotEmpty()) result.add(str)
        }
        return  result
    }
}