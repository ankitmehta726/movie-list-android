package com.am.movielist.repo.model

import com.am.movielist.db.entity.Movie
import com.google.gson.annotations.SerializedName


/**
 * Created by ankitmehta726
 */
data class MovieResult(
    @SerializedName("page") var page: Int,
    @SerializedName("results") var results: ArrayList<Movie>,
    @SerializedName("total_results") var totalResults: Int,
    @SerializedName("total_pages") var totalPages: Int
)