package com.melyseev.cocktails.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.melyseev.cocktails.presentation.ui.drink_list.getAllDrinkFilterCategories

@Composable
fun FilterDialog(
    getValueCheck:(String)->Boolean,
    onChecked: (String)->Unit,
    onCloseDialog: () -> Unit,
) {
    AlertDialog(
        modifier = Modifier
            //.fillMaxSize()
            .padding(8.dp)
            //.testTag(TAG_HERO_FILTER_DIALOG)
        ,
        onDismissRequest = {
            onCloseDialog()
        },
        title = {
            Text(
                text = "Filter",
                style = MaterialTheme.typography.h4,
            )
        },
        text = {

            LazyColumn {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {


                        //alcoholic, ingredients, glass, category
                        val list = getAllDrinkFilterCategories()

                        list.forEach {

                            val changeLetter = it.first().lowercase()
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 12.dp)
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = null, // disable the highlight
                                        enabled = true,
                                        onClick = {
                                            // filterOnHero()
                                            onChecked(changeLetter)
                                        },
                                    ),
                            ) {
                                Checkbox(
                                    modifier = Modifier
                                        .padding(end = 8.dp),

                                    checked = getValueCheck(changeLetter),
                                    onCheckedChange = {
                                        onChecked(changeLetter)
                                    },
                                    colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
                                )
                                Text(
                                    text = it,
                                    style = MaterialTheme.typography.h6,
                                )

                            }
                        }
                    }



                    }




            }

        },
        buttons = {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    // make the icon larger so it's easier to click
                    modifier = Modifier
                        .align(Alignment.End)
                        //.testTag(TAG_HERO_FILTER_DIALOG_DONE)
                        .clickable {
                           onCloseDialog()
                        },
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(10.dp),
                        imageVector = Icons.Default.Check,
                        contentDescription = "Done",
                        tint = Color(0xFF009a34)
                    )
                }

            }
        }
    )
}