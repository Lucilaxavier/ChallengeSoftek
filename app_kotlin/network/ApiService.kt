package br.com.softmind.network

import br.com.softmind.data.modelos.AvaliacaoRequest
import br.com.softmind.data.modelos.AvaliacaoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("api/avaliacoes")
    suspend fun enviarAvaliacao(
        @Body body: AvaliacaoRequest,
        @Header("Authorization") token: String
    ): Response<AvaliacaoResponse>
}
