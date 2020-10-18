package com.am.movielist.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AndroidInjectionModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app: Application): Builder
    }
}