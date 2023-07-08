package com.example.notejitpack.helper

import androidx.room.TypeConverter
import java.util.Date

/**
 * Created by kannanpvm007 on 08-07-2023.
 */
class DateConverter {
    @TypeConverter
    fun timeStampFormDate(date:Date):Long= date.time

    @TypeConverter
    fun dateFromTimeStamp(timeStamp:Long):Date= Date(timeStamp)

}