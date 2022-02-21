package com.melyseev.cocktails.presentation.ui.drink_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.melyseev.cocktails.datastore.DataStoreApplication
import com.melyseev.cocktails.datastore.NO_VALUE_CONST
import com.melyseev.cocktails.network_status.ConnectivityManagerNetworkAvailable
import com.melyseev.cocktails.presentation.components.AppSearchBar
import com.melyseev.cocktails.presentation.components.DrinkList
import com.melyseev.cocktails.presentation.components.FilterDialog
import com.melyseev.cocktails.presentation.components.LoadingResult
import com.melyseev.cocktails.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
@ExperimentalComposeUiApi
class DrinkListFragment: Fragment() {

    private val viewModel: DrinkListViewModel by viewModels()

    @Inject
    lateinit var dataStore: DataStoreApplication

    @Inject
    lateinit var connectivityManager: ConnectivityManagerNetworkAvailable



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return super.onCreateView(inflater, container, savedInstanceState)
        return ComposeView(requireContext()).apply {

            setContent {


                //first time
                if (!viewModel.loaded.value
                    && viewModel.dataStore.valueCategory.value != NO_VALUE_CONST
                ) {

                    viewModel.query.value = viewModel.dataStore.valueCategory.value
                    viewModel.categoryScrollPosition = getIndexDrinkCategoryValue(
                        category = viewModel.dataStore.category.value,
                        viewModel.dataStore.valueCategory.value
                    )

                    println("1 category - ${viewModel.dataStore.category.value}")
                    viewModel.setCheckedStates()
                    viewModel.onTriggerEvent(DrinkListEvent.NewFilterAlcoholicEvent)
                }

                if (!viewModel.loaded.value) {
                    LoadingResult()
                    return@setContent
                }


                Box {
                    val showFilterDialog = remember { mutableStateOf(false) }
                    AppTheme(
                        darkTheme = viewModel.dataStore.isDark.value,
                        isNetworkAvailable = connectivityManager.isNetworkAvailable.value
                    ) {
                        val scaffoldState = rememberScaffoldState()

                        Scaffold(

                            topBar = {
                                AppSearchBar(
                                    query = viewModel.query.value,
                                    newSearch = { viewModel.onTriggerEvent(DrinkListEvent.NewFilterAlcoholicEvent) },
                                    onQueryChange = viewModel::onQueryChange,
                                    onSelectedValueCategoryChanged = viewModel::onSelectedValueCategoryChanged,
                                    selectedValueCategory = viewModel.dataStore.valueCategory.value,
                                    categoryValueScrollPosition = viewModel.categoryScrollPosition,
                                    getDrinkCategoriesValues = {
                                        println("2 category - ${viewModel.dataStore.category.value}")
                                        getValuesByCurrentCategory(category = viewModel.dataStore.category.value)
                                    },
                                    onToggleTheme = { showFilterDialog.value = true }
                                )
                            },
                            scaffoldState = scaffoldState,
                        ) {
                            DrinkList(
                                loading = viewModel.loading.value,
                                drinks = viewModel.drinks.value,
                                errorOccurs = viewModel.errorLoading.value,
                                categoryStr = viewModel.dataStore.category.value + " | " + viewModel.dataStore.valueCategory.value,
                                onReload = { viewModel.onTriggerEvent(DrinkListEvent.NewFilterAlcoholicEvent) },
                                onChangeScrollPosition = {},
                                navController = findNavController(),
                                scaffoldState = scaffoldState,
                            )
                        }
                    }


                    if (showFilterDialog.value) {
                        FilterDialog(

                            getValueCheck = {
                                return@FilterDialog viewModel.getCheckedStateByValue(it)
                            },
                            onChecked = { newCategory ->
                                viewModel.onChangedCheckedFilter(newCategory)
                            }) {
                            showFilterDialog.value = false
                            viewModel.updateViewWithNewCategory()
                            viewModel.onTriggerEvent(DrinkListEvent.NewFilterAlcoholicEvent)
                        }
                    }
                }
            }
        }

    }
}