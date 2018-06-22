package com.example.tramalho.firebaselab

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.iid.FirebaseInstanceId



/**
 * Gera o token unico do dispositivo
 */
class FirebaseInstanceIdServiceImp : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        super.onTokenRefresh()

        val token = FirebaseInstanceId.getInstance().token

        //nesse ponto realizar chamadas para quaisquer interessados pelo
        //token unico

        Log.d(javaClass.simpleName, "Novo token ${token}")
    }
}
