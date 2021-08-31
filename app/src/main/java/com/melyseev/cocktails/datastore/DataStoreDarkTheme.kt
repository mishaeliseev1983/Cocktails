package com.melyseev.cocktails.datastore

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.melyseev.cocktails.BaseApplication
import dagger.hilt.android.qualifiers.ApplicationContext

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataStoreDarkTheme
@Inject constructor(    val baseApplication: BaseApplication ) {
    private val scope = CoroutineScope(Dispatchers.Main)
    val BaseApplication.prefsDataStore: DataStore<Preferences>  by preferencesDataStore( name = "pref")

    init {
        observeDataStore()

    }

    companion object{
        val IS_DARK_THEME = booleanPreferencesKey("is_dark_theme")
    }

    val isDark = mutableStateOf(false)

    fun toggleTheme(){
        scope.launch {

            baseApplication.prefsDataStore.edit {
                    preferences ->
                val current = preferences[IS_DARK_THEME]?:false
                preferences[IS_DARK_THEME] = !current
                //isDark.value = !current
            }
        }

    }
    private fun observeDataStore() {

        baseApplication.prefsDataStore.data.onEach { preferences ->
            preferences[IS_DARK_THEME]?.let{

                    isDarkTheme->
                print(" is_dark = $isDarkTheme")
                isDark.value = isDarkTheme
            }

        }.launchIn(scope = scope)
    }

}