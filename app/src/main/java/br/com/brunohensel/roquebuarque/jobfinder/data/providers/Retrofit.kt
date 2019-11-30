package br.com.brunohensel.roquebuarque.jobfinder.data.providers

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofit by lazy { makeRetrofit() }

/**
 * Create retrofit instance
 */
private fun makeRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://jobs.github.com/")
        .client(makeHttpClient())
        .addConverters()
        .build()

/**
 * Add adapter to retrofit instance like rx and gson adapters
 */
private fun Retrofit.Builder.addConverters(): Retrofit.Builder = this
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

/**
 * Apply http client to retrofit instance
 */
private fun makeHttpClient() = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(makeHeadersInterceptor())
        .addInterceptor(makeLoggingInterceptor())
        .build()