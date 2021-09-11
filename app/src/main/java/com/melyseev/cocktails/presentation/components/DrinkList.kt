package com.melyseev.cocktails.presentation.components

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.melyseev.cocktails.R
import com.melyseev.cocktails.domain.model.DrinkShort
import kotlinx.coroutines.delay

@Composable
fun DrinkList(
    loading: Boolean,
    drinks: List<DrinkShort>,
    onChangeScrollPosition: (Int) -> Unit,
    navController: NavController,
    scaffoldState: ScaffoldState
) {
    if (loading && drinks.isEmpty()) {

    } else if(drinks.isEmpty()){
        println("drinks list empty")
        NothingResult()
    } else {
        println("drinks list not empty")
        LazyColumn {
            itemsIndexed(items = drinks) { index, one_drink ->
                onChangeScrollPosition(index)
               /*
                if ((index + 1) >= (page * RECIPE_PAGINATION_PAGE_SIZE) && !loading) {
                    nextPageLoad()
                    Log.w("Recipe", " ${index + 1 }  !!!!" )

                }

                */

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
    //DefaultSnackBar(snackbarHostState = scaffoldState.snackbarHostState)
}