package br.com.softmind.data.repositorio

import br.com.softmind.network.ApiService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import retrofit2.Response

class ApoioRepositoryTest {
    private lateinit var api: ApiService
    private lateinit var repo: ApoioRepository

    @Before
    fun setup() {
        api = mock(ApiService::class.java)
        repo = ApoioRepository(api)
    }

    @Test
    fun `deve retornar lista de apoio quando sucesso`() = runBlocking {
        val lista = listOf(br.com.softmind.data.modelos.ApoioResponse("1", "Psicólogo", "Apoio emocional", "contato@softtek.com"))
        `when`(api.listarApoio(anyString())).thenReturn(Response.success(lista))
        val result = repo.listarApoio("token")
        assertEquals(lista, result)
    }

    @Test
    fun `deve retornar null quando falha`() = runBlocking {
        `when`(api.listarApoio(anyString())).thenReturn(Response.error(400, okhttp3.ResponseBody.create(null, "")))
        val result = repo.listarApoio("token")
        assertNull(result)
    }
}
