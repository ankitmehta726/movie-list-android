package com.am.movielist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.am.movielist.AppViewModelFactory
import com.am.movielist.R
import com.am.movielist.di.Injectable
import javax.inject.Inject

/**
 * Created by ankitmehta726
 */

class MovieListFragment: Fragment(), Injectable {

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        movieListViewModel = ViewModelProvider(this, appViewModelFactory)
            .get(MovieListViewModel::class.java)
    }
}