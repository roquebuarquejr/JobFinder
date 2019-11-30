package br.com.brunohensel.roquebuarque.jobfinder.feature.list.presentation

import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListInteractor
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListState
import br.com.brunohensel.roquebuarque.jobfinder.utils.applySchedulers
import io.reactivex.Observable

class JobListViewModel(private val interactor:JobListInteractor) {

    fun getJobList(): Observable<JobListState> =
        interactor
            .fetchJobList()
            .applySchedulers()
}