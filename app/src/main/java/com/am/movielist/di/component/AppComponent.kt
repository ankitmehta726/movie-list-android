package com.am.movielist.di.component

import android.app.Application
import com.am.MovieApp
import com.am.movielist.di.module.AppModule
import com.am.movielist.di.module.MainActivityModule
import com.am.movielist.di.module.RoomModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AppModule::class, MainActivityModule::class, RoomModule::class])
interface AppComponent: AndroidInjector<MovieApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: MovieApp?)
}