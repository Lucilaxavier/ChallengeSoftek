package br.com.softmind.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.softmind.data.repositorio.LogRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import br.com.softmind.data.modelos.LogResponse

class LogViewModel(private val repo: LogRepository) : ViewModel() {
    val logs = MutableLiveData<List<LogResponse>?>()

    fun carregarLogs(token: String) {
        viewModelScope.launch {
            logs.value = repo.listarLogs(token)
        }
    }
}
