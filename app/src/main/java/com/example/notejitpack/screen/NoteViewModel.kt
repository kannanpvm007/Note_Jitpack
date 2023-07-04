package com.example.notejitpack.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.notejitpack.data.Note

/**
 * Created by kannanpvm007 on 05-07-2023.
 */
class NoteViewModel:ViewModel() {
   private var noteList= mutableStateListOf<Note>()

    fun addNote(note: Note){
        noteList.add(note)
    }
    fun removeNote(note: Note){
        noteList.remove(note)
    }
    fun getAllNotes():List<Note> = noteList
}