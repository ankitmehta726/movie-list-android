package com.am.movielist.di.module;

import com.am.movielist.ui.MovieListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract MovieListFragment contributeMovieListFragment();
}
