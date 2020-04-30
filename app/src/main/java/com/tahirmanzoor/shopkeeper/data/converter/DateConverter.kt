package com.tahirmanzoor.shopkeeper.data.converter

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun calenderToTimestamp(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun timestampToCalendar(timestamp: Long): Date {
        var date = Date()
        date.time = timestamp
        return date
    }
}