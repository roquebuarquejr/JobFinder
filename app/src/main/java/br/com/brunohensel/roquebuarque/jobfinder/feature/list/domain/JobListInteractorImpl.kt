package br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain

import androidx.annotation.VisibleForTesting
import br.com.brunohensel.roquebuarque.jobfinder.base.BaseState
import br.com.brunohensel.roquebuarque.jobfinder.data.JobApi
import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData
import io.reactivex.Observable
import io.reactivex.Observable.defer
import javax.inject.Inject

class JobListInteractorImpl @Inject constructor(private val api: JobApi) {

    /**
     * state for [JobListState]
     */
    val observable = fetchJobList()

    @VisibleForTesting
    fun fetchJobList(): Observable<JobListState> =
        defer {
            api
                .getJobPositions()
                .map { Success(it) }
                .cast(JobListState::class.java)
                .onErrorReturn { Failure("Deu ruim") }
        }


}

/**
 * Class with all Job List states
 */
sealed class JobListState : BaseState

/**
 * When [JobListInteractorImpl.fetchJobList] is success
 */
data class Success(val list: List<JobData>) : JobListState()

/**
 * When [JobListInteractorImpl.fetchJobList] is failure
 */
data class Failure(val message: String) : JobListState()
