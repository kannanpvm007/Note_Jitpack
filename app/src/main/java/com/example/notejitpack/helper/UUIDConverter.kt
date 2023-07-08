package com.example.notejitpack.helper

import androidx.room.TypeConverter
import java.util.UUID

/**
 * Created by kannanpvm007 on 08-07-2023.
 */
class UUIDConverter {
    @TypeConverter
    fun fromUUID(uuid: UUID):String? =uuid.toString()
    @TypeConverter
    fun UUIDFromString(uuid:String):UUID? =UUID.fromString(uuid)

}