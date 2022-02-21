package com.melyseev.cocktails.presentation.components

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@Composable
fun AppSearchBar(
    query: String,
    newSearch:()->Unit,
    onQueryChange:(String)->Unit,
    onSelectedValueCategoryChanged:(String)->Unit,
    /*
    onChangeValueCategoryScrollPosition:(Int)->Unit,

     */
    //currentCategory: String,
    selectedValueCategory: String,
    categoryValueScrollPosition: Int,
    getDrinkCategoriesValues: ()-> MutableList<String>,
   /* getIndexCategoryValue:(String) -> Int,*/
    onToggleTheme:()->Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val stateScrollPosition = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Surface(

        elevation = 8.dp,
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.surface
    ) {


        Column {

            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .padding(8.dp),

                    value = query,
                    label = { Text(text = "Search by first letter") },

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    leadingIcon = { Icon(Icons.Filled.Search, "") },


                    keyboardActions =
                    KeyboardActions(onSearch = {
                        newSearch()
                        keyboardController?.hide()
                    }),

                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                    //backgroundColor = TextStyle(color = MaterialTheme.colors.surface),
                    onValueChange = {
                            newValue ->
                               onQueryChange(newValue)
                    })


                IconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onClick = { onToggleTheme()  },
                ) {

                    Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "")
                }


                /*
                ConstraintLayout(modifier = Modifier.align(Alignment.CenterVertically))
                {
                    val menu = createRef()
                    IconButton(
                        modifier = Modifier.constrainAs(menu) {
                            end.linkTo(parent.end)
                            linkTo(top = parent.top, bottom = parent.bottom)
                        },
                        onClick = onToggleTheme,
                    ) {

                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "")
                    }
                }

                 */

            }



            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
                state = stateScrollPosition

            ) {

                Log.w(" --", "categoryScrollPosition - $categoryValueScrollPosition")

                itemsIndexed(items = getDrinkCategoriesValues()) { index, categoryValue ->

                    DrinkViewCategoryChip(
                        category = categoryValue,
                        isSelected = selectedValueCategory == categoryValue,
                        onExecuteSearch = {
                            newSearch()
                        },
                        onSelectedValueCategoryChanged = {
                            onSelectedValueCategoryChanged(it)

                            /*
                            onChangeValueCategoryScrollPosition(
                                getIndexCategoryValue(categoryValue)
                            )

                             */
                        }
                    )
                }
            }


        }


        coroutineScope.launch {
            if (categoryValueScrollPosition != -1 ) {
                stateScrollPosition.scrollToItem(categoryValueScrollPosition)
            }
        }
    }



}