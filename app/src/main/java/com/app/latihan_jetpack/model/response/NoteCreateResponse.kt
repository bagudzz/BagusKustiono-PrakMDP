package com.app.latihan_jetpack.model.response

data class NoteCreateResponse {
    val code:Int,
    val message: String,
    val data: NoteItemCreate
}

data class NoteItemCreate{
    val id: String,
    val title: String,
    val content: String
}