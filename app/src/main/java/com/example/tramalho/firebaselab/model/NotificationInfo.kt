package com.example.tramalho.firebaselab.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Essa classe foi anotada como mapeamento do banco apenas
 * com propositos de estudo, em projetos reais verificar
 * a possibilidade de existir uma entidade com esse
 * proposito
 *
 */
@Entity
data class NotificationInfo(
        @PrimaryKey(autoGenerate = true)
        var id: Long?,
        @ColumnInfo(name = "title")
        val title: String,
        @ColumnInfo(name = "message")
        val message: String)
