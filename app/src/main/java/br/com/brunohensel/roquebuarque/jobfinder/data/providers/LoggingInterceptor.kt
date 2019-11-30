package br.com.brunohensel.roquebuarque.jobfinder.data.providers

import br.com.brunohensel.roquebuarque.jobfinder.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE

/**
 * Interceptor to apply log when is debug build config
 */
fun makeLoggingInterceptor() = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) BODY else NONE
}