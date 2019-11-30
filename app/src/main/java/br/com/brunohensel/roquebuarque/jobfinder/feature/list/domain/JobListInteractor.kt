package br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain

import io.reactivex.Observable

interface JobListInteractor {

    fun fetchJobList(): Observable<JobListState>
}