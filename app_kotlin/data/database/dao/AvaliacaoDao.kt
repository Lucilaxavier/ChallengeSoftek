package br.com.softmind.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.softmind.data.database.entidades.AvaliacaoLocal

@Dao
interface AvaliacaoDao {
    @Insert
    suspend fun inserir(avaliacao: AvaliacaoLocal)

    @Query("SELECT * FROM AvaliacaoLocal WHERE enviado = 0")
    suspend fun listarPendentes(): List<AvaliacaoLocal>
}
