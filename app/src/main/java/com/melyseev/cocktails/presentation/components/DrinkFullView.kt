package com.melyseev.cocktails.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.melyseev.cocktails.domain.model.DrinkFull
import com.melyseev.cocktails.util.DEFAULT_DRINK_IMAGE
import com.melyseev.cocktails.util.loadPicture

const val IMAGE_HEIGHT = 295

@Composable
fun DrinkFullView(drinkFull: DrinkFull) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        val drink_title = drinkFull.strDrink
        val instructions = drinkFull.strInstructions
        val url = drinkFull.strDrinkThumb

        val listIngredients = mutableListOf<String>()
        listIngredients.add(drinkFull.strIngredient1?:"")
        listIngredients.add(drinkFull.strIngredient2?:"")
        listIngredients.add(drinkFull.strIngredient3?:"")
        listIngredients.add(drinkFull.strIngredient4?:"")
        listIngredients.add(drinkFull.strIngredient5?:"")
        listIngredients.add(drinkFull.strIngredient6?:"")

        listIngredients.add(drinkFull.strIngredient7?:"")
        listIngredients.add(drinkFull.strIngredient8?:"")
        listIngredients.add(drinkFull.strIngredient9?:"")
        listIngredients.add(drinkFull.strIngredient10?:"")
        listIngredients.add(drinkFull.strIngredient11?:"")
        listIngredients.add(drinkFull.strIngredient12?:"")
        listIngredients.add(drinkFull.strIngredient13?:"")
        listIngredients.add(drinkFull.strIngredient14?:"")
        listIngredients.add(drinkFull.strIngredient15?:"")


        val listMeasures = mutableListOf<String>()
        listMeasures.add(drinkFull.strMeasure1?:"")
        listMeasures.add(drinkFull.strMeasure2?:"")
        listMeasures.add(drinkFull.strMeasure3?:"")
        listMeasures.add(drinkFull.strMeasure4?:"")
        listMeasures.add(drinkFull.strMeasure5?:"")
        listMeasures.add(drinkFull.strMeasure6?:"")

        listMeasures.add(drinkFull.strMeasure7?:"")
        listMeasures.add(drinkFull.strMeasure8?:"")
        listMeasures.add(drinkFull.strMeasure9?:"")
        listMeasures.add(drinkFull.strMeasure10?:"")
        listMeasures.add(drinkFull.strMeasure11?:"")
        listMeasures.add(drinkFull.strMeasure12?:"")
        listMeasures.add(drinkFull.strMeasure13?:"")
        listMeasures.add(drinkFull.strMeasure14?:"")
        listMeasures.add(drinkFull.strMeasure15?:"")


        item {
            val image = loadPicture(url = url, defaultImage = DEFAULT_DRINK_IMAGE).value

            image?.let {
                Image(
                    bitmap = image.asImageBitmap(),
                    contentDescription = drink_title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(IMAGE_HEIGHT.dp)
                )
            }
        }




        item {
            Text(
                text = drink_title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                style = MaterialTheme.typography.h4
            )
        }

        item {
            Text(
                text = instructions,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                style = MaterialTheme.typography.h6
            )
        }

      listIngredients.forEachIndexed { index, one ->

            one?.let {
                if(it.isNotEmpty()) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Text(
                                text = it,
                                modifier = Modifier
                                    .fillMaxWidth(0.65f)
                                    .wrapContentWidth(Alignment.Start),
                                style = MaterialTheme.typography.h5
                            )


                            val measure = listMeasures[index]
                            Text(
                                text = measure,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.End)
                                    .align(Alignment.CenterVertically),
                                style = MaterialTheme.typography.h6
                            )
                        }
                    }
                }
            }
        }
    }





}