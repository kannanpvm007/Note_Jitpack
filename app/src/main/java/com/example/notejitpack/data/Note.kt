package com.example.notejitpack.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RenameTable
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

/**
 * Created by kannanpvm007 on 04-07-2023.
 */

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name="note_description")
    val description:String,
    @ColumnInfo(name = "entry_time")
    val entryTime: Date=Date.from(Instant.now())

)
