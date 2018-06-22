package com.example.tramalho.firebaselab

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging


/**
 * Gera o token unico do dispositivo
 */
class FirebaseInstanceIdServiceImp : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        super.onTokenRefresh()

        val token = FirebaseInstanceId.getInstance().token

        //deve existir o mesmo topico no FCM
        FirebaseMessaging.getInstance().subscribeToTopic("fcm_topic")

        //nesse ponto realizar chamadas para quaisquer interessados pelo
        //token unico
        //TODO

        Log.d(javaClass.simpleName, "Novo token ${token}")
    }
}
