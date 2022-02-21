package com.melyseev.cocktails.interactors.app

import android.util.Log
import com.melyseev.cocktails.presentation.ui.drink.TAG
import java.net.InetSocketAddress
import javax.net.SocketFactory

object HasInternet {

    fun execute(socketFactory: SocketFactory): Boolean {
        return try {
            Log.d(TAG, "execute: PINGING GOOGLE")

            val socket = socketFactory.createSocket()
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            Log.d(TAG,  "execute: SUCCESS ANSWER GOOGLE")
            true
        } catch (e: Exception) {
            Log.e(TAG, "execute : has no internet $e")
            false
        }
    }

}