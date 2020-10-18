package com.am.movielist.repo

import androidx.lifecycle.LiveData
import com.am.movielist.db.entity.Movie
import com.am.movielist.repo.api.MovieService
import com.am.movielist.repo.model.ApiResponse
import com.am.movielist.repo.model.MovieResult
import com.am.movielist.repo.util.AppExecutors
import com.am.movielist.repo.util.NetworkBoundResource
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by ankitmehta726
 */

@Singleton
class MovieRepository
@Inject
constructor(
    var movieService: MovieService,
    val appExecutors: AppExecutors
){
    fun getPopularMovies(): NetworkBoundResource<List<Movie>, MovieResult> {
        return object : NetworkBoundResource<List<Movie>, MovieResult>(appExecutors){
            override fun saveCallResult(item: MovieResult?) {
                mMovieDao.insertMovies(item?.results)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Movie>> {
                return mMovieDao.findAll()
            }

            override fun createCall(): LiveData<ApiResponse<MovieResult>> {
                return movieService.getPopularMovies()
            }
        }
    }
}