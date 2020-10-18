package com.am.movielist.repo.model

import com.google.gson.annotations.SerializedName


/**
 * Created by ankitmehta726
 */
data class MovieResult(
    @SerializedName("page") var page: Int,
    @SerializedName("results") var results: ArrayList<Any>,
    @SerializedName("total_results") var totalResults: Int,
    @SerializedName("total_pages") var totalPages: Int
)