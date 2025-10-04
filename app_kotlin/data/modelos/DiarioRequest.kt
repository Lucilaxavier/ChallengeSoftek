package br.com.softmind.data.modelos

data class DiarioRequest(
    val anonId: String,
    val humor: String,
    val comentario: String?
)

data class DiarioResponse(
    val id: String,
    val humor: String
)
