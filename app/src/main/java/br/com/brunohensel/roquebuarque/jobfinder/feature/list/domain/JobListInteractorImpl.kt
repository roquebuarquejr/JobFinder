package br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain

import br.com.brunohensel.roquebuarque.jobfinder.data.JobApi
import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData
import br.com.brunohensel.roquebuarque.jobfinder.data.providers.retrofit
import io.reactivex.Observable

class JobListInteractorImpl : JobListInteractor {

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
sealed class JobListState

/**
 * When [JobListInteractor.fetchJobList] is success
 */
data class Success(val list: List<JobData>) : JobListState()

/**
 * When [JobListInteractor.fetchJobList] is failure
 */
data class Failure(val message: String) : JobListState()
