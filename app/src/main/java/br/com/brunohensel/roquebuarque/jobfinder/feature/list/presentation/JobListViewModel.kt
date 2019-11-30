package br.com.brunohensel.roquebuarque.jobfinder.feature.list.presentation

import br.com.brunohensel.roquebuarque.jobfinder.base.BaseViewModel
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListInteractorImpl
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListState
import br.com.brunohensel.roquebuarque.jobfinder.utils.applySchedulers
import io.reactivex.Observable
import javax.inject.Inject

class JobListViewModel @Inject constructor(private val interactor: JobListInteractorImpl) :
    BaseViewModel() {

    fun getJobList(): Observable<JobListState> =
        interactor
            .fetchJobList()
            .applySchedulers()
}