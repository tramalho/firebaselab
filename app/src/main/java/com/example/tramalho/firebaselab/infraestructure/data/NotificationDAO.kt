package com.example.tramalho.firebaselab.infraestructure.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.tramalho.firebaselab.model.NotificationInfo

@Dao
interface NotificationDAO{

    @Query("SELECT * from NotificationInfo")
    fun getAll(): List<NotificationInfo>

    @Insert(onConflict = REPLACE)
    fun save(notificationInfo: NotificationInfo)
}
