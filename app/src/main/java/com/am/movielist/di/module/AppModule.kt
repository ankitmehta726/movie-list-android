package com.am.movielist.di.module

import androidx.lifecycle.ViewModel
import com.am.movielist.repo.api.MovieService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by ankitmehta726
 */

@Module(
    includes = [
        NetworkModule::class,
        ViewModelModule::class
    ]
)
class AppModule {

    @Provides
    @Singleton
    internal fun provideMovieService(retrofit: Retrofit) = retrofit.create(MovieService::class.java)
}