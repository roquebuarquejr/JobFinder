package br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain

import br.com.brunohensel.roquebuarque.jobfinder.base.BaseState
import br.com.brunohensel.roquebuarque.jobfinder.data.JobApi
import br.com.brunohensel.roquebuarque.jobfinder.data.model.Job
import br.com.brunohensel.roquebuarque.jobfinder.data.providers.retrofit
import io.reactivex.Observable
import javax.inject.Inject

class JobListInteractorImpl @Inject constructor() : JobListInteractor {

    private val api = retrofit.create(JobApi::class.java)

    override fun fetchJobList(): Observable<JobListState> =
        api
            .getJobPositions()
            .map { Success(it) }
            .cast(JobListState::class.java)
            .onErrorReturn { Failure("Deu ruim") }

}

/**
 * Class with all Job List states
 */
sealed class JobListState: BaseState()

/**
 * When [JobListInteractor.fetchJobList] is success
 */
data class Success(val list: List<Job>) : JobListState()

/**
 * When [JobListInteractor.fetchJobList] is failure
 */
data class Failure(val message: String) : JobListState()
