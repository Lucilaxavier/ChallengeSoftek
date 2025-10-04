package br.com.softmind.data.repositorio

import br.com.softmind.data.modelos.AvaliacaoRequest
import br.com.softmind.data.modelos.AvaliacaoResponse
import br.com.softmind.data.database.dao.AvaliacaoDao
import br.com.softmind.data.database.entidades.AvaliacaoLocal
import br.com.softmind.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AvaliacaoRepository(
    private val api: ApiService,
    private val dao: AvaliacaoDao
) {
    suspend fun enviarAvaliacao(request: AvaliacaoRequest, token: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = api.enviarAvaliacao(request, "Bearer $token")
            if (response.isSuccessful) {
                true
            } else {
                dao.inserir(AvaliacaoLocal(respostas = request.respostas.toString(), risco = request.risco, enviado = false))
                false
            }
        }
    }

    suspend fun listarPendentes(): List<AvaliacaoLocal> = dao.listarPendentes()
}
