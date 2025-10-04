package br.com.softmind.data.repositorio

import br.com.softmind.data.modelos.DiarioRequest
import br.com.softmind.data.modelos.DiarioResponse
import br.com.softmind.data.database.dao.DiarioDao
import br.com.softmind.data.database.entidades.DiarioLocal
import br.com.softmind.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DiarioRepository(
    private val api: ApiService,
    private val dao: DiarioDao
) {
    suspend fun enviarCheckin(request: DiarioRequest, token: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = api.enviarCheckin(request, "Bearer $token")
            if (response.isSuccessful) {
                true
            } else {
                dao.inserir(DiarioLocal(humor = request.humor, comentario = request.comentario, enviado = false))
                false
            }
        }
    }

    suspend fun listarPendentes(): List<DiarioLocal> = dao.listarPendentes()
}
