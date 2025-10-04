package br.com.softmind.data.database.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DiarioLocal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val humor: String,
    val comentario: String?,
    val enviado: Boolean = false
)
