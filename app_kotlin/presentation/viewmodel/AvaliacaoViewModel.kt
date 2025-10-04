package br.com.softmind.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.softmind.data.repositorio.AvaliacaoRepository
import br.com.softmind.data.modelos.AvaliacaoRequest
import kotlinx.coroutines.launch

class AvaliacaoViewModel(private val repo: AvaliacaoRepository) : ViewModel() {
    fun enviarAvaliacao(request: AvaliacaoRequest, token: String) {
        viewModelScope.launch {
            repo.enviarAvaliacao(request, token)
        }
    }
}
