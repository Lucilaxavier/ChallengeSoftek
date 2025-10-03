package com.softtek.challenge.repository

import android.content.Context
import com.softtek.challenge.data.*
import com.softtek.challenge.network.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BackendRepository(context: Context) {
    private val db = AppDatabaseProvider.getDatabase(context)
    private val api: ApiService
    private val anonId = UserAnonManager.getAnonId(context)
    private var token: String = "" // Receber do backend se necessário

    init {
        api = Retrofit.Builder()
            .baseUrl("http://SEU_BACKEND:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    suspend fun enviarAvaliacao(respostas: List<Map<String, String>>, risco: String): Boolean {
        return withContext(Dispatchers.IO) {
            val req = AvaliacaoRequest(anonId, respostas, risco)
            val resp = api.enviarAvaliacao(req, "Bearer $token")
            if (resp.isSuccessful) {
                // Marcar como enviado no banco local
                true
            } else {
                // Salvar localmente para tentar depois
                db.avaliacaoDao().inserir(AvaliacaoLocal(respostas.toString(), risco, enviado = false))
                false
            }
        }
    }

    suspend fun enviarCheckin(humor: String, comentario: String?): Boolean {
        return withContext(Dispatchers.IO) {
            val req = DiarioRequest(anonId, humor, comentario)
            val resp = api.enviarCheckin(req, "Bearer $token")
            if (resp.isSuccessful) {
                true
            } else {
                db.diarioDao().inserir(DiarioLocal(humor, comentario, enviado = false))
                false
            }
        }
    }

    suspend fun listarApoio(): List<ApoioResponse>? {
        return withContext(Dispatchers.IO) {
            val resp = api.listarApoio("Bearer $token")
            if (resp.isSuccessful) resp.body() else null
        }
    }

    // ... outros métodos
}
