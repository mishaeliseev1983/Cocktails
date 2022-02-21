package com.melyseev.cocktails.presentation.components

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.melyseev.cocktails.R
import com.melyseev.cocktails.domain.model.DrinkShort
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DrinkList(
    loading: Boolean,
    drinks: List<DrinkShort>,
    errorOccurs: String,
    categoryStr: String,
    onReload:()->Unit,
    onChangeScrollPosition: (Int) -> Unit,
    navController: NavController,
    scaffoldState: ScaffoldState,
) {
    if (errorOccurs.isNotEmpty()) {
        NothingResult(message = errorOccurs, onReload = onReload )

    }else
    if (loading && drinks.isEmpty()) {

    } /*else if(drinks.isEmpty()){
        println("drinks list empty")
        NothingResult(message = categoryStr, onReload = onReload )
    } */else {
        println("drinks list not empty")
        LazyColumn {
            itemsIndexed(items = drinks) { index, one_drink ->
                onChangeScrollPosition(index)
                DrinkCard(drink = one_drink, onClick = {
                    val bundle= Bundle()
                    bundle.putString("drink_id", one_drink.idDrink?: "")
                    navController.navigate(R.id.viewRecipe, bundle)
                    Log.w("Full Drink", " 1.  Try load drink index= ${index}, title = ${one_drink.strDrink}" )

                }, index)
            }
        }

    }
    CircularIndeterminateProgressBar(isDisplayed = loading)
}