package br.com.brunohensel.roquebuarque.jobfinder.data.providers

import br.com.brunohensel.roquebuarque.jobfinder.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE

fun makeLoggingInterceptor() = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) BODY else NONE
}