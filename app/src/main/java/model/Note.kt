package model

data class Note(
    val id: Long = System.currentTimeMillis(),
    val text: String
)
