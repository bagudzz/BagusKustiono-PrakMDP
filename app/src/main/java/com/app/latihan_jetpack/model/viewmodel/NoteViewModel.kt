package com.app.latihan_jetpack.model.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.latihan_jetpack.model.response.NoteItem
import com.app.latihan_jetpack.service.api.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteViewModel: ViewModel() {
    private val _notes = MutableStateFlow<List<NoteItem>>(emptyList())

    val notes : StateFlow<List<NoteItem>> = _notes

    private fun getNotes(){
        viewModelScope.launch {
            try {
                val response = ApiClient.instance.getAllNotes()
                _notes.value = response.data.notes
            }catch(e: Exception){
                Log.e("GetNotesError", "gagal mengambil data catatan")
            }
        }
    }
    init {
        getNotes()
    }
}