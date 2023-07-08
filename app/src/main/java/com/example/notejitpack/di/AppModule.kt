package com.example.notejitpack.di

import android.content.Context
import androidx.room.Room
import com.example.notejitpack.db.NoteDatabase
import com.example.notejitpack.db.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by kannanpvm007 on 07-07-2023.
 */
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDatabaseDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context:Context) : NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java,"note_database" )
//            .fallbackToDestructiveMigration()
            .build()
}