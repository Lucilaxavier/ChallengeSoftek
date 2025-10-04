package br.com.softmind.data.database.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AvaliacaoLocal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val respostas: String,
    val risco: String,
    val enviado: Boolean = false
)
