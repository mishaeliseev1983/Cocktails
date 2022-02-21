package com.melyseev.cocktails.network_status

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleOwner

import com.melyseev.cocktails.BaseApplication
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnectivityManagerNetworkAvailable
@Inject
constructor( val baseApplication: BaseApplication){
    private val connectionLiveData:ConnectionLiveData = ConnectionLiveData(baseApplication)

    val isNetworkAvailable:MutableState<Boolean> = mutableStateOf(true)

    fun updateCheckConnection(){
        connectionLiveData.validNetworks.clear()
        connectionLiveData.checkValidNetworks()
    }


    fun registerConnectionObserver(lifecycleOwner: LifecycleOwner){
        connectionLiveData.observe( lifecycleOwner , {isConnected ->
            isConnected?.let {
                isConnected->
                isConnected?.let {
                    isNetworkAvailable.value = it
                }
            }
        } )
    }

    fun unregisterConnectionObserver(lifecycleOwner: LifecycleOwner){
        connectionLiveData.removeObservers(lifecycleOwner)
    }

}