package com.am.movielist.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.am.movielist.db.entity.Movie

/**
 * Created by ankitmehta726
 */

@Dao
abstract class MovieDao {

    @Query("SELECT * FROM Movie")
    abstract fun findAll(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg movie: Movie?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movieList: List<Any>)

    @Query("DELETE FROM Movie")
    abstract fun deleteAll()

    @Query("SELECT * FROM Movie where title = :title")
    abstract fun searchMovieByTitle(title: String?): LiveData<List<Movie>>

    @Query("SELECT * FROM Movie where id = :id")
    abstract fun searchMovieById(id: Int): LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun createMovieIfNotExists(movie: Movie): Long
}