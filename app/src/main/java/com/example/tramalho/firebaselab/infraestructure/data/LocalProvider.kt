package com.example.tramalho.firebaselab.infraestructure.data

import android.content.Context
import android.util.Log
import com.example.tramalho.firebaselab.model.NotificationInfo

class LocalProvider {

    fun save(notificationInfo: NotificationInfo, context: Context) {
        //idealmente isso deve ser injetado
        val dao = AppDataBase.getInstance(context).provideNotificationDAO()
        dao.save(notificationInfo)
        Log.d(javaClass.simpleName, notificationInfo.toString())
    }

    fun retrieveAll(context: Context): List<NotificationInfo> {
        val dao = AppDataBase.getInstance(context).provideNotificationDAO()
        val all = dao.getAll()
        Log.d(javaClass.simpleName, "retrieveAll : ${all.size}")
        return all
    }
}

