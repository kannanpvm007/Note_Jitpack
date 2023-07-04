package com.example.notejitpack.data

import java.time.LocalDateTime
import java.util.UUID

/**
 * Created by kannanpvm007 on 04-07-2023.
 */
data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description:String,
    val entryTime: LocalDateTime=LocalDateTime.now(),

)
