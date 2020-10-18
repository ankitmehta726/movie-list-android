package com.am.movielist.repo

import androidx.lifecycle.LiveData
import com.am.movielist.db.dao.MovieDao
import com.am.movielist.db.entity.Movie
import com.am.movielist.repo.api.MovieService
import com.am.movielist.repo.model.ApiResponse
import com.am.movielist.repo.model.MovieResult
import com.am.movielist.repo.util.AppExecutors
import com.am.movielist.repo.util.NetworkBoundResource
import com.am.movielist.vo.Resource
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
    val appExecutors: AppExecutors,
    val movieDao: MovieDao
){
    fun getPopularMovies(): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, MovieResult>(appExecutors){
            override fun saveCallResult(item: MovieResult?) {
                movieDao.insertMovies(item?.results)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Movie>> {
                return movieDao.findAll()
            }

            override fun createCall(): LiveData<ApiResponse<MovieResult>> {
                return movieService.getPopularMovies()
            }
        }.asLiveData()
    }
}