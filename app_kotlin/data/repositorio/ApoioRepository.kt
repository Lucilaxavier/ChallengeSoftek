package br.com.softmind.data.repositorio

import br.com.softmind.data.modelos.ApoioResponse
import br.com.softmind.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApoioRepository(private val api: ApiService) {
    suspend fun listarApoio(token: String): List<ApoioResponse>? {
        return withContext(Dispatchers.IO) {
            val response = api.listarApoio("Bearer $token")
            if (response.isSuccessful) response.body() else null
        }
    }
}
