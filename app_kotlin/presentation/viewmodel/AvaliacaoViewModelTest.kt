package br.com.softmind.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.softmind.data.modelos.AvaliacaoRequest
import br.com.softmind.data.repositorio.AvaliacaoRepository
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class AvaliacaoViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `deve chamar repo ao enviar avaliacao`() {
        val repo = mock(AvaliacaoRepository::class.java)
        val viewModel = AvaliacaoViewModel(repo)
        val request = AvaliacaoRequest("anonId", emptyList(), "baixo")
        viewModel.enviarAvaliacao(request, "token")
        verify(repo).enviarAvaliacao(request, "token")
    }
}
