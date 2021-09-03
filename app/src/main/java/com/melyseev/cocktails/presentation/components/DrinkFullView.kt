package com.melyseev.cocktails.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.melyseev.cocktails.domain.model.DrinkFull

@Composable
fun DrinkFullView(drinkFull: DrinkFull) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        drinkFull.strDrink?.let {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.45f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h4
                    )

                    val rank = drinkFull.strInstructions
                    Text(
                        text = rank.toString(),
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