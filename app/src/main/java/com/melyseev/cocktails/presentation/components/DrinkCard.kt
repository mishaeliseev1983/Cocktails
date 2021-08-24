package com.melyseev.cocktails.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.melyseev.cocktails.domain.model.DrinkShort
import com.melyseev.cocktails.util.DEFAULT_RECIPE_IMAGE
import com.melyseev.cocktails.util.loadPicture

@Composable
fun DrinkCard(drink: DrinkShort, onClick: () -> Unit, index: Int){

    Card(shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp, top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick)
    )
    {
        Column {

            drink.strDrinkThumb?.let {
                val image = loadPicture(url = it, defaultImage = DEFAULT_RECIPE_IMAGE).value


                image?.let {
                    Image(
                        bitmap = image.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().height(225.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                drink.strDrink?.let { title ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                    ) {
                        Text(
                            text = title,
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(Alignment.Start),
                            style = MaterialTheme.typography.h5
                        )
                        Text(
                            //text = recipe.rating.toString(),
                            text = index.toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.End)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.h6
                        )
                    }
                }

/*
            recipe.featuredImage?.let {



                val image = loadPicture(url = it, defaultImage = DEFAULT_RECIPE_IMAGE).value

                image?.let {

                    Image(
                        bitmap = image.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp),
                        contentScale = ContentScale.Crop)
                }

                recipe.title?.let { title ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                    ) {
                        Text(
                            text = title,
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(Alignment.Start),
                            style = MaterialTheme.typography.h5
                        )
                        Text(
                            //text = recipe.rating.toString(),
                            text = index.toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.End)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.h6
                        )
                    }
                }

            }
*/
            }
            }
    }
}