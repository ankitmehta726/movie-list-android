package com.am.movielist.db

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import androidx.room.util.StringUtil


/**
 * Created by ankitmehta726
 */

@SuppressLint("RestrictedApi")
class MovieTypeConverters {
    @TypeConverter
    fun stringToIntList(data: String?): List<Int?>? {
        return if (data == null) {
            emptyList<Int>()
        } else StringUtil.splitToIntList(data)
    }

    @TypeConverter
    fun intListToString(ints: List<Int?>?): String? {
        return StringUtil.joinIntoString(ints)
    }
}