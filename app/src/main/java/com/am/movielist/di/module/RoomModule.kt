package com.am.movielist.di.module

import android.app.Application
import androidx.room.Room
import com.am.movielist.db.MovieDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ankitmehta726
 */

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(app: Application): MovieDB {
        return Room.databaseBuilder(app, MovieDB::class.java, "movie_db").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(movieDB: MovieDB) = movieDB.movieDao()
}