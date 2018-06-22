package com.example.tramalho.firebaselab


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.*
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager.*
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Service responsavel por interceptar notificacoes
 */
class FirebaseMessagingServiceImp : FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        val notificationInfo = retrieveData(remoteMessage)

        notificationInfo?.let {
            createNotification(it.title?:getString(R.string.app_name), it.message)
        }
    }

    private fun retrieveData(remoteMessage: RemoteMessage?): NotificationInfo? {

        val notification = remoteMessage?.notification
        val data = remoteMessage?.data

        notification?.let {
            return NotificationInfo(it.title?: "", it.body?: "")
        }

        // aqui foi utilizada uma convencao pois no payload deve existir uma
        // chave title e outra body
        data?.let {
            return NotificationInfo(it["title"]?: "", it["body"]?: "")
        }

        return null
    }

    private fun createNotification(title: String?, message: String?) {

        Log.d(this::class.java.simpleName, "onMessageReceived: ${title} / ${message}")

        val channelId = getString(R.string.default_notification_channel_id)

        val notificationBuilder = createNotificationBuilder(channelId, title, message)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        configureChannel(channelId, notificationManager)

        notificationManager.notify(666 /* ID of notification */, notificationBuilder.build());
    }

    private fun configureChannel(channelId: String?, nofiticationManager: NotificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val notificationChannel = NotificationChannel(channelId, "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT)

            nofiticationManager.createNotificationChannel(notificationChannel)
        }
    }

    private fun createNotificationBuilder(channelId: String, title: String?, message: String?)
            : NotificationCompat.Builder {

        val pendingIntent = createPendingIntent()

        val defaultUri = getDefaultUri(TYPE_NOTIFICATION)

        val notificationBuilder =
                NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setSound(defaultUri)
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent)

        return notificationBuilder
    }

    private fun createPendingIntent(): PendingIntent {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        return getActivity(this, 666, intent, FLAG_ONE_SHOT)
    }

    private data class NotificationInfo(val title : String, val message : String)
}