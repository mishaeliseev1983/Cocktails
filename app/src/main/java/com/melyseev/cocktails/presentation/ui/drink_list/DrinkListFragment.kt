package com.melyseev.cocktails.presentation.ui.drink_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.melyseev.cocktails.BaseApplication
import com.melyseev.cocktails.datastore.DataStoreDarkTheme
import com.melyseev.cocktails.presentation.components.AppSearchBar
import com.melyseev.cocktails.presentation.components.DrinkList
import com.melyseev.cocktails.presentation.theme.AppTheme
import com.melyseev.cocktails.presentation.util.ConnectivityManagerNetworkAvailable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
@ExperimentalComposeUiApi
class DrinkListFragment: Fragment() {

    private val viewModel: DrinkListViewModel by viewModels()
    @Inject
    lateinit var application: BaseApplication
    @Inject
    lateinit var darkTheme: DataStoreDarkTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return super.onCreateView(inflater, container, savedInstanceState)
        return ComposeView(requireContext()).apply {

            /*
            setContent {


                var drinks = viewModel.drinks.value
                val loading = viewModel.loading
                val scaffoldState = rememberScaffoldState()
                DrinkList(
                    loading = loading,
                    drinks = drinks,
                    onChangeScrollPosition = {},
                    navController = findNavController(),
                    scaffoldState = scaffoldState
                )
            }

        */

            setContent {

                AppTheme(
                    darkTheme = darkTheme.isDark.value,
                    isNetworkAvailable = viewModel.connectivityManager.isNetworkAvailable.value
                ) {
                    var drinks = viewModel.drinks.value
                    //val page = viewModel.page.value
                    val loading = viewModel.loading.value
                    val categoryScrollPosition = viewModel.categoryScrollPosition
                    val scaffoldState = rememberScaffoldState()

                    Scaffold(

                        topBar = {
                            AppSearchBar(
                                query = viewModel.query.value,
                                newSearch = { viewModel.onTriggerEvent(DrinkListEvent.NewFilterAlcoholicEvent) },
                                onQueryChange = viewModel::onQueryChange,
                                onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                                onChangeCategoryScrollPosition = {
                                viewModel::onChangeCategoryScrollPosition
                                },
                                selectedCategory = viewModel.selectedCategory.value,
                                categoryScrollPosition = categoryScrollPosition,
                                onToggleTheme = { darkTheme.toggleTheme() }
                            )
                        },
                        scaffoldState = scaffoldState,
                    ){
                        DrinkList(
                            loading = loading,
                            drinks = drinks,
                            onChangeScrollPosition = {},
                            navController = findNavController(),
                            scaffoldState = scaffoldState
                        )
                    }
                }

            }
        }

    }
}