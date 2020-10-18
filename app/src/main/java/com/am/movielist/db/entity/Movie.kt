package com.am.movielist.db.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.TypeConverters
import com.am.movielist.db.MovieTypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ankitmehta726
 */

@Entity(indices = [Index("id")], primaryKeys = ["id"])
@TypeConverters(MovieTypeConverters::class)
data class Movie(
    @SerializedName("id") @Expose @NonNull var id: Int,
    @SerializedName("poster_path") var posterUrl: String,
    var rating: Double,
    @SerializedName("release_date") var releaseYear: String,
    var title: String,
    var adult: Boolean,
    var overview: String,
    @SerializedName("original_title") var originalTitle: String,
    @SerializedName("original_language") var originalLanguage: String,
    @SerializedName("backdrop_path") var backdropPath: String,
    var popularity: Double,
    @SerializedName("vote_count") var voteCount: Int,
    var video: Boolean,
    @SerializedName( "vote_average") var voteAverage: Double
)