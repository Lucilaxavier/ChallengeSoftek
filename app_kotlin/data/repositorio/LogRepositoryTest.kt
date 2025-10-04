package br.com.softmind.data.repositorio

import br.com.softmind.network.ApiService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import retrofit2.Response

class LogRepositoryTest {
    private lateinit var api: ApiService
    private lateinit var repo: LogRepository

    @Before
    fun setup() {
        api = mock(ApiService::class.java)
        repo = LogRepository(api)
    }

    @Test
    fun `deve retornar lista de logs quando sucesso`() = runBlocking {
        val lista = listOf(br.com.softmind.data.modelos.LogResponse("1", "Login", "Usuário logado", "2025-10-04"))
        `when`(api.listarLogs(anyString())).thenReturn(Response.success(lista))
        val result = repo.listarLogs("token")
        assertEquals(lista, result)
    }

    @Test
    fun `deve retornar null quando falha`() = runBlocking {
        `when`(api.listarLogs(anyString())).thenReturn(Response.error(400, okhttp3.ResponseBody.create(null, "")))
        val result = repo.listarLogs("token")
        assertNull(result)
    }
}
