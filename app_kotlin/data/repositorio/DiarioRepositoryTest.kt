package br.com.softmind.data.repositorio

import br.com.softmind.data.modelos.DiarioRequest
import br.com.softmind.network.ApiService
import br.com.softmind.data.database.dao.DiarioDao
import br.com.softmind.data.database.entidades.DiarioLocal
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import retrofit2.Response

class DiarioRepositoryTest {
    private lateinit var api: ApiService
    private lateinit var dao: DiarioDao
    private lateinit var repo: DiarioRepository

    @Before
    fun setup() {
        api = mock(ApiService::class.java)
        dao = mock(DiarioDao::class.java)
        repo = DiarioRepository(api, dao)
    }

    @Test
    fun `deve retornar true quando envio de check-in for bem-sucedido`() = runBlocking {
        val request = DiarioRequest("anonId", "Feliz", "Dia bom")
        `when`(api.enviarCheckin(any(), anyString())).thenReturn(Response.success(null))
        val result = repo.enviarCheckin(request, "token")
        assertTrue(result)
    }

    @Test
    fun `deve salvar localmente quando envio de check-in falhar`() = runBlocking {
        val request = DiarioRequest("anonId", "Feliz", "Dia bom")
        `when`(api.enviarCheckin(any(), anyString())).thenReturn(Response.error(400, okhttp3.ResponseBody.create(null, "")))
        val result = repo.enviarCheckin(request, "token")
        verify(dao).inserir(any())
        assertFalse(result)
    }
}
