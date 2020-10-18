package com.am.movielist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.am.movielist.R
import com.am.movielist.db.entity.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie_layout.view.*


/**
 * Created by ankitmehta726
 */
class MovieListAdapter(var context: Context, var movieList: ArrayList<Movie>):
RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_layout, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val (_, posterUrl1) = movieList[position]
        val posterUrl =
            holder.ivPoster.context.getString(R.string.movie_image_url) +
                    holder.ivPoster.context
                        .getString(R.string.image_size_780) + posterUrl1

        Glide.with(holder.ivPoster.context)
            .load(posterUrl)
            .into(holder.ivPoster)
    }

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
        val itemView = view.cvItem
        val ivPoster = view.ivPoster
    }
}