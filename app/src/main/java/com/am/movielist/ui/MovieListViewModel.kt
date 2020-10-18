package com.am.movielist.ui

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.am.movielist.db.entity.Movie
import com.am.movielist.repo.MovieRepository
import com.am.movielist.vo.Resource
import javax.inject.Inject


/**
 * Created by ankitmehta726
 */
class MovieListViewModel
@Inject
constructor(var movieRepository: MovieRepository): ViewModel(){

    private val moviesLiveData: LiveData<Resource<List<Movie>>> = movieRepository.getPopularMovies()

    @VisibleForTesting
    fun getPopularMovies(): LiveData<Resource<List<Movie>>> {
        return moviesLiveData
    }
}