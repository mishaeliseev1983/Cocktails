package com.melyseev.cocktails.presentation.ui.drink

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.melyseev.cocktails.BaseApplication
import com.melyseev.cocktails.datastore.DataStoreDarkTheme
import com.melyseev.cocktails.presentation.components.CircularIndeterminateProgressBar
import com.melyseev.cocktails.presentation.components.DrinkFullView
import com.melyseev.cocktails.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

const val TAG = "DrinkFullFragment"

@AndroidEntryPoint
@ExperimentalComposeUiApi
class DrinkFullFragment: Fragment() {

    private val viewModel: DrinkFullViewModel by viewModels()

    @Inject
    lateinit var application: BaseApplication

    @Inject
    lateinit var darkTheme: DataStoreDarkTheme

    var drinkId: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        arguments?.getString("drink_id")?.let {
            Log.d(TAG, " drink_id = ${it}")
            drinkId = it
            viewModel.onTriggeredEvent(DrinkFullEvent.GetDrinkFilterById(drinkId ?: ""))
        }
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {

            println(" theme= ${darkTheme.isDark.value}")
            setContent {

                AppTheme(
                    darkTheme = darkTheme.isDark.value,
                    isNetworkAvailable = viewModel.connectivityManager.isNetworkAvailable.value
                ) {

                    val scaffoldState = rememberScaffoldState()
                    val loading = viewModel.loading.value
                    Scaffold(
                        scaffoldState = scaffoldState,
                    ) {
                        viewModel.drinkFull?.let {

                            it.value?.let {
                                DrinkFullView(drinkFull = it)
                            }
                        }
                        CircularIndeterminateProgressBar(isDisplayed = loading)
                    }
                }
                /*
                viewModel.drinkFull?.let {

                    it.value?.let {
                        DrinkFullView(drinkFull = it)
                    }
                }

                CircularIndeterminateProgressBar(isDisplayed = viewModel.loading.value)

            }
                 */

            }
        }
    }

}