package com.softtek.challenge.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AvaliacaoLocal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val respostas: String,
    val risco: String,
    val enviado: Boolean = false
)

@Entity
data class DiarioLocal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val humor: String,
    val comentario: String?,
    val enviado: Boolean = false
)
