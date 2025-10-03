package com.softtek.challenge.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AvaliacaoDao {
    @Insert
    suspend fun inserir(avaliacao: AvaliacaoLocal)

    @Query("SELECT * FROM AvaliacaoLocal WHERE enviado = 0")
    suspend fun listarPendentes(): List<AvaliacaoLocal>
}

@Dao
interface DiarioDao {
    @Insert
    suspend fun inserir(diario: DiarioLocal)

    @Query("SELECT * FROM DiarioLocal WHERE enviado = 0")
    suspend fun listarPendentes(): List<DiarioLocal>
}
