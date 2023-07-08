package com.example.notejitpack.repostory

import com.example.notejitpack.data.Note
import com.example.notejitpack.db.NoteDatabase
import com.example.notejitpack.db.NoteDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by kannanpvm007 on 08-07-2023.
 */

class NoteRepository @Inject constructor(private val dao :NoteDatabaseDao) {
    suspend fun addNote(note:Note)= dao. addNote(note)

    suspend fun update(note: Note)=dao.updateNote(note)

    suspend fun deleteNote(note: Note)=dao.deleteNote(note)

    suspend fun deleteAll()=dao.deleteAllNotes()

    suspend fun getAllNotes() : Flow<List<Note>> = dao.getNotes().flowOn(Dispatchers.IO).conflate()

}