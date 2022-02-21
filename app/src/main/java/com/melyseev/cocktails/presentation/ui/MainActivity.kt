package com.melyseev.cocktails.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent

import com.melyseev.cocktails.R
import com.melyseev.cocktails.datastore.DataStoreApplication
import com.melyseev.cocktails.network_status.ConnectivityManagerNetworkAvailable
import com.melyseev.cocktails.presentation.components.LoadingResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var dataStore: DataStoreApplication

    @Inject
    lateinit var connectivityManager: ConnectivityManagerNetworkAvailable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



    override fun onStart() {

        super.onStart()
        connectivityManager.updateCheckConnection()
        connectivityManager.registerConnectionObserver(this)
    }

    override fun onStop() {
        connectivityManager.unregisterConnectionObserver(this)
        super.onStop()
    }


}