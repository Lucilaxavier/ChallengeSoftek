package com.softtek.challenge.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Header

// Requests

data class AvaliacaoRequest(
    val anonId: String,
    val respostas: List<Map<String, String>>,
    val risco: String
)

data class DiarioRequest(
    val anonId: String,
    val humor: String,
    val comentario: String?
)

// Responses

data class AvaliacaoResponse(val id: String, val risco: String)
data class DiarioResponse(val id: String, val humor: String)
data class ApoioResponse(val id: String, val tipo: String, val descricao: String, val contato: String)

interface ApiService {
    @POST("api/avaliacoes")
    suspend fun enviarAvaliacao(@Body body: AvaliacaoRequest, @Header("Authorization") token: String): Response<AvaliacaoResponse>

    @POST("api/diario")
    suspend fun enviarCheckin(@Body body: DiarioRequest, @Header("Authorization") token: String): Response<DiarioResponse>

    @GET("api/apoio")
    suspend fun listarApoio(@Header("Authorization") token: String): Response<List<ApoioResponse>>

    // ... outros endpoints
}
