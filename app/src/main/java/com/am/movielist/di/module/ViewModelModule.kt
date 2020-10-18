package com.am.movielist.di.module

import androidx.lifecycle.ViewModelProvider
import com.am.movielist.AppViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by ankitmehta726
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory)
            : ViewModelProvider.Factory
}