package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailInteractor

import br.com.brunohensel.roquebuarque.jobfinder.data.JobApi
import br.com.brunohensel.roquebuarque.jobfinder.data.JobFailure
import br.com.brunohensel.roquebuarque.jobfinder.data.JobState
import br.com.brunohensel.roquebuarque.jobfinder.data.JobSuccess
import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData
import br.com.brunohensel.roquebuarque.jobfinder.data.providers.retrofit
import io.reactivex.Observable

class JobDetailInteractor {

    private val request = retrofit.create(
        JobApi::class.java
    )

    fun getJobDescriptionData(): Observable<JobState> =
        request
            .getPositionDetail()
            .map { JobMapper(it) }
            .cast(JobState::class.java)
            .doOnError { it.printStackTrace() }
            .onErrorReturn { JobFailure("Error") }
}

object JobMapper {
    operator fun invoke(result: JobData): JobSuccess {
        return JobSuccess(result)

    }

}