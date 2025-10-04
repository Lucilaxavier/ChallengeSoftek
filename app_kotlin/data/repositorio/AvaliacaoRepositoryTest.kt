package br.com.softmind.data.repositorio

import br.com.softmind.data.modelos.AvaliacaoRequest
import br.com.softmind.network.ApiService
import br.com.softmind.data.database.dao.AvaliacaoDao
import br.com.softmind.data.database.entidades.AvaliacaoLocal
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import retrofit2.Response

class AvaliacaoRepositoryTest {
    private lateinit var api: ApiService
    private lateinit var dao: AvaliacaoDao
    private lateinit var repo: AvaliacaoRepository

    @Before
    fun setup() {
        api = mock(ApiService::class.java)
        dao = mock(AvaliacaoDao::class.java)
        repo = AvaliacaoRepository(api, dao)
    }

    @Test
    fun `deve retornar true quando envio de avaliacao for bem-sucedido`() = runBlocking {
        val request = AvaliacaoRequest("anonId", listOf(mapOf("pergunta" to "Como está?", "resposta" to "Bem")), "baixo")
        `when`(api.enviarAvaliacao(any(), anyString())).thenReturn(Response.success(null))
        val result = repo.enviarAvaliacao(request, "token")
        assertTrue(result)
    }

    @Test
    fun `deve salvar localmente quando envio de avaliacao falhar`() = runBlocking {
        val request = AvaliacaoRequest("anonId", listOf(mapOf("pergunta" to "Como está?", "resposta" to "Bem")), "baixo")
        `when`(api.enviarAvaliacao(any(), anyString())).thenReturn(Response.error(400, okhttp3.ResponseBody.create(null, "")))
        val result = repo.enviarAvaliacao(request, "token")
        verify(dao).inserir(any())
        assertFalse(result)
    }
}
