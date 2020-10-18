package com.am.movielist.repo.util


/**
 * Created by ankitmehta726
 */
object AppConstants {

    /**
     * Connection timeout duration
     */
    val CONNECT_TIMEOUT = 60 * 1000L

    /**
     * Connection Read timeout duration
     */
    val READ_TIMEOUT = 60 * 1000L

    /**
     * Connection write timeout duration
     */
    val WRITE_TIMEOUT = 60 * 1000L

    /**
     * Endpoint
     */
    val BASE_URL = "http://api.themoviedb.org/3/"


    var DEBUG = true
}