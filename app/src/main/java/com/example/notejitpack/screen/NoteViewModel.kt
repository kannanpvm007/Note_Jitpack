package com.example.notejitpack.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notejitpack.data.Note
import com.example.notejitpack.repostory.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by kannanpvm007 on 05-07-2023.
 */
@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) :ViewModel() {
   private var _noteList= MutableStateFlow<List<Note>>(emptyList())
    val noteList =_noteList.asStateFlow()

    init {
       getAllNotes()
    }

    private fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect{noteList->
                _noteList.value =noteList
            }
        }
    }

    fun addNote(note: Note){
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }
      fun updateNote(note: Note){
        viewModelScope.launch {
            noteRepository.update(note)
        }
    }
      fun removeNote(note: Note){
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }
      fun removeAllNote(){
        viewModelScope.launch {
            noteRepository.deleteAll()
        }
    }
}