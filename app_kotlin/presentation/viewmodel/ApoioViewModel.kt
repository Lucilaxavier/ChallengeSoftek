package br.com.softmind.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.softmind.data.repositorio.ApoioRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import br.com.softmind.data.modelos.ApoioResponse

class ApoioViewModel(private val repo: ApoioRepository) : ViewModel() {
    val canaisApoio = MutableLiveData<List<ApoioResponse>?>()

    fun carregarApoio(token: String) {
        viewModelScope.launch {
            canaisApoio.value = repo.listarApoio(token)
        }
    }
}
