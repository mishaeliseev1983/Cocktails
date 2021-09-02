package com.melyseev.cocktails.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.melyseev.cocktails.R
import com.melyseev.cocktails.presentation.util.ConnectivityManagerNetworkAvailable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var connectivityManager: ConnectivityManagerNetworkAvailable

    override fun onStart() {
        super.onStart()
        connectivityManager.registerConnectionObserver(lifecycleOwner = this)
    }

    override fun onDestroy() {
        super.onDestroy()
        connectivityManager.unregisterConnectionObserver(lifecycleOwner = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}