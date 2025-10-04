package br.com.softmind.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.softmind.data.database.entidades.DiarioLocal

@Dao
interface DiarioDao {
    @Insert
    suspend fun inserir(diario: DiarioLocal)

    @Query("SELECT * FROM DiarioLocal WHERE enviado = 0")
    suspend fun listarPendentes(): List<DiarioLocal>
}
