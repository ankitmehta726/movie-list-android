package com.am.movielist.di.module

import androidx.annotation.NonNull
import com.am.movielist.BuildConfig
import com.am.movielist.repo.api.AuthInterceptor
import com.am.movielist.repo.util.AppConstants.BASE_URL
import com.am.movielist.repo.util.AppConstants.CONNECT_TIMEOUT
import com.am.movielist.repo.util.AppConstants.READ_TIMEOUT
import com.am.movielist.repo.util.AppConstants.WRITE_TIMEOUT
import com.am.movielist.repo.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by ankitmehta726
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkHttpInterceptors(): HttpLoggingInterceptor? {
        return HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    /**
     * Configure OkHttpClient. This helps us override some of the default configuration. Like the
     * connection timeout.
     *
     * @return OkHttpClient
     */
    @Provides
    @Singleton
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor?): OkHttpClient? {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofitClient(@NonNull okHttpClient: OkHttpClient?): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()) // Serialize Objects
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //Set call to return {@link Observable}
            .build()
    }
}