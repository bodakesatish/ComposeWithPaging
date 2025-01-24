package com.bodakesatish.composewithpaging.data.di.interceptors

import android.content.Context
import com.bodakesatish.composewithpaging.data.common.NetworkException
import com.bodakesatish.composewithpaging.data.common.NetworkHelper
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkConnectionInterceptor @Inject constructor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (!NetworkHelper.isNetworkAvailable(context)) {
            throw NetworkException()
        }

        return chain.proceed(request)
    }
}

