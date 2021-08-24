package com.melyseev.cocktails.presentation.components

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
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

    } else {
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
                    //val bundle= Bundle()
                    //bundle.putInt("recipe_id", recipe.id?: -1)
                    //navController.navigate(R.id.viewRecipe, bundle)
                    //Log.w("Recipe", " 1.  Try load recipe index= ${index}, title = ${recipe.title}" )

                }, index)
            }
        }

    }
    CircularIndeterminateProgressBar(isDisplayed = loading)
    //DefaultSnackBar(snackbarHostState = scaffoldState.snackbarHostState)
}