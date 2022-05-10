package com.petter.datasource.network.utils

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor(private val context: Context, private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }
}