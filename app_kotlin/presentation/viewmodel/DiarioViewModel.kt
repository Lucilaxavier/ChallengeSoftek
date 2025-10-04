package br.com.softmind.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.softmind.data.repositorio.DiarioRepository
import br.com.softmind.data.modelos.DiarioRequest
import kotlinx.coroutines.launch

class DiarioViewModel(private val repo: DiarioRepository) : ViewModel() {
    fun enviarCheckin(request: DiarioRequest, token: String) {
        viewModelScope.launch {
            repo.enviarCheckin(request, token)
        }
    }
}
