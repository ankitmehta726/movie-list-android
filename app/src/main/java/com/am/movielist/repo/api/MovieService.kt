package com.am.movielist.repo.api

import androidx.lifecycle.LiveData
import com.am.movielist.repo.model.ApiResponse
import com.am.movielist.repo.model.MovieResult
import retrofit2.http.GET

interface MovieService {

    @GET("movie/popular?")
    fun getPopularMovies(): LiveData<ApiResponse<MovieResult>>
}