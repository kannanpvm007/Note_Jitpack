package com.example.notejitpack.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notejitpack.data.Note
import com.example.notejitpack.helper.DateConverter
import com.example.notejitpack.helper.UUIDConverter

/**
 * Created by kannanpvm007 on 08-07-2023.
 */

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase :RoomDatabase() {
abstract fun noteDao(): NoteDatabaseDao
}