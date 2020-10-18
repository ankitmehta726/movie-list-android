package com.am.movielist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.am.movielist.AppViewModelFactory
import com.am.movielist.R
import com.am.movielist.db.entity.Movie
import com.am.movielist.di.Injectable
import com.am.movielist.vo.Resource
import com.am.movielist.vo.Status
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

/**
 * Created by ankitmehta726
 */

class MovieListFragment : Fragment(), Injectable {

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    private lateinit var movieListViewModel: MovieListViewModel

    private lateinit var movieList: ArrayList<Movie>

    private lateinit var movieListAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieList = ArrayList()
        movieListAdapter = MovieListAdapter(activity as MainActivity, movieList)
    }

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

        recyclerView.apply {
            layoutManager = GridLayoutManager(activity as MainActivity, 3)
            adapter = movieListAdapter
        }

        observeMoviesResponse()
    }

    private fun observeMoviesResponse(/*moviesResource: Resource<List<Movie>>*/) {

        movieListViewModel.getPopularMovies()
            .observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Status.ERROR -> {
                        progressbar.visibility = View.GONE
                        tvError.text = it.message
                    }
                    Status.LOADING -> {
                        progressbar.visibility = View.VISIBLE
                        tvError.visibility = View.GONE
                    }
                    Status.SUCCESS -> {
                        progressbar.visibility = View.GONE
                        tvError.visibility = View.GONE
                        if (it.data != null && it.data.isNotEmpty()) {
                            movieList.clear()
                            movieList.addAll(it.data)
                            /*movieListAdapter.setItems(moviesResource.data)*/
                            movieListAdapter.notifyDataSetChanged()
                        } else {
                            tvError.text = resources.getString(R.string.no_result)
                            tvError.visibility = View.VISIBLE
                        }
                    }
                    else -> {
                        progressbar.visibility = View.GONE
                        tvError.text = resources.getString(R.string.error_no_results)
                    }
                }
            })
    }
}