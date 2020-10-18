package com.am.movielist.repo

import androidx.lifecycle.LiveData
import com.am.movielist.repo.api.MovieService
import com.am.movielist.repo.util.AppExecutors
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
    val appExecutors: AppExecutors
){
//    fun getPopularMovies(): LiveData<Resource<List<Movie>>>
}