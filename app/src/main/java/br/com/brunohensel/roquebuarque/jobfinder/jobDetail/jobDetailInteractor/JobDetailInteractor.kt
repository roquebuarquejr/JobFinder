package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailInteractor

import br.com.brunohensel.roquebuarque.jobfinder.data.JobApi
import br.com.brunohensel.roquebuarque.jobfinder.data.JobDetailState
import br.com.brunohensel.roquebuarque.jobfinder.data.JobFailure
import br.com.brunohensel.roquebuarque.jobfinder.data.JobSuccess
import io.reactivex.Observable
import javax.inject.Inject

class JobDetailInteractor @Inject constructor(private val api: JobApi) {

    val observable = getJobDescriptionData("")

    fun getJobDescriptionData(jobId: String?): Observable<JobDetailState> =
        api
            .getPositionDetail(jobId)
            .map { JobSuccess(it) }
            .cast(JobDetailState::class.java)
            .doOnError { it.printStackTrace() }
            .onErrorReturn { JobFailure("Error") }
}
