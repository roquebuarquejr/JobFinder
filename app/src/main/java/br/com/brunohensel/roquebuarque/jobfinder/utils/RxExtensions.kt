package br.com.brunohensel.roquebuarque.jobfinder.utils

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io

fun <T> Observable<T>.applySchedulers(): Observable<T> =
    subscribeOn(io())
        .observeOn(mainThread())
