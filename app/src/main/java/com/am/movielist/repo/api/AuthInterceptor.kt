package com.am.movielist.repo.api

import androidx.annotation.NonNull
import com.am.movielist.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by ankitmehta726
 */
class AuthInterceptor: Interceptor {

    @Throws(IOException::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response? {
        var request = chain.request()
        val url = request.url().newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}