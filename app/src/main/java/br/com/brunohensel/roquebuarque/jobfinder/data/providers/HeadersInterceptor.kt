package br.com.brunohensel.roquebuarque.jobfinder.data.providers

import okhttp3.Interceptor

/**
 * Provide interceptor to apply headers
 */
fun makeHeadersInterceptor() = Interceptor { chain ->
    chain.proceed(chain.request().newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Accept-Language", "en")
            .addHeader("Content-Type", "application/json")
            .build())
}