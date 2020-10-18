package com.am.movielist.di.component

import android.app.Application
import com.am.movielist.di.module.AppModule
import com.am.movielist.di.module.MainActivityModule
import com.am.movielist.di.module.RoomModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AppModule::class, MainActivityModule::class, RoomModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
    }
}