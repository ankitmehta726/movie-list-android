package com.am.movielist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.am.movielist.db.dao.MovieDao
import com.am.movielist.db.entity.Movie


/**
 * Created by ankitmehta726
 */

/**
 * Main database description.
 */

@Database(entities = [Movie::class], version = 1)
abstract class MovieDB : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}