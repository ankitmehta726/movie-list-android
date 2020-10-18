package com.am.movielist.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.am.movielist.AppViewModelFactory
import com.am.movielist.di.key.ViewModelKey
import com.am.movielist.ui.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by ankitmehta726
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory)
            : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindMovieListViewModel(movieListViewModel: MovieListViewModel?): ViewModel?
}