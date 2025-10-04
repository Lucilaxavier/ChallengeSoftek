package br.com.softmind.data.modelos

data class AvaliacaoRequest(
    val anonId: String,
    val respostas: List<Map<String, String>>,
    val risco: String
)

data class AvaliacaoResponse(
    val id: String,
    val risco: String
)
