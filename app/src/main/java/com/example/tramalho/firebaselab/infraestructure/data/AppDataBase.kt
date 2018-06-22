package com.example.tramalho.firebaselab.infraestructure.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.tramalho.firebaselab.model.NotificationInfo

@Database(entities = arrayOf(NotificationInfo::class), version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun provideNotificationDAO(): NotificationDAO

    companion object {

        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {

            synchronized(this) {

                if (instance == null) {
                    instance = create(context)
                }

                return instance as AppDataBase
            }
        }


        private fun create(context: Context): AppDataBase {
            return Room.databaseBuilder(context,
                    AppDataBase::class.java, "Sample.db")
                    .build()
        }
    }
}