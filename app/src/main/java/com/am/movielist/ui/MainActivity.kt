package com.am.movielist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.am.movielist.viewmodel.AppViewModelFactory
import com.am.movielist.R
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    private lateinit var navController: NavController

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        //Getting the Navigation Controller
        navController = Navigation.findNavController(this, R.id.home_nav_host_fragment)
        navController.setGraph(R.navigation.nav_graph_home);
    }

    override fun androidInjector() = fragmentDispatchingAndroidInjector
}