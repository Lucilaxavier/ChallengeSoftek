package br.com.softmind.data.repositorio

import br.com.softmind.data.modelos.LogResponse
import br.com.softmind.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LogRepository(private val api: ApiService) {
    suspend fun listarLogs(token: String): List<LogResponse>? {
        return withContext(Dispatchers.IO) {
            val response = api.listarLogs("Bearer $token")
            if (response.isSuccessful) response.body() else null
        }
    }
}
