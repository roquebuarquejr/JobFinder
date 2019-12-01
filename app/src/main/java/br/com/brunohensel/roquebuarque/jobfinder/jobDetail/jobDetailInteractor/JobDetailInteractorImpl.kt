package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailInteractor

import br.com.brunohensel.roquebuarque.jobfinder.data.JobApi
import br.com.brunohensel.roquebuarque.jobfinder.data.JobDetailState
import br.com.brunohensel.roquebuarque.jobfinder.data.JobFailure
import br.com.brunohensel.roquebuarque.jobfinder.data.JobSuccess
import io.reactivex.Observable
import io.reactivex.Observable.defer
import io.reactivex.Observable.empty
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class JobDetailInteractorImpl @Inject constructor(private val api: JobApi) : JobDetailInteractor {

    private val subjectActions = BehaviorSubject.create<JobDetailActions>()
    val observable: Observable<JobDetailState> = defer {
        subjectActions
            .share()
            .switchMap {
                if (it is Search) {
                    getJobDescriptionData(it.jobId)
                } else  {
                    empty()
                }
            }
    }

    private fun getJobDescriptionData(jobId: String?): Observable<JobDetailState> =
        api
            .getPositionDetail(jobId)
            .map { JobSuccess(it) }
            .cast(JobDetailState::class.java)
            .doOnError { it.printStackTrace() }
            .onErrorReturn { JobFailure("Error") }

    override fun search(id: String?) {
        subjectActions
            .onNext(Search(id))
    }
}


/**
 *  [JobDetailActions] View actions
 */
sealed class JobDetailActions

/**
 *  Class trigger search action and store jobId
 */
data class Search(val jobId: String?) : JobDetailActions()

/**
 * Contract interface class [JobDetailInteractorImpl]
 * with view interactions
 */
interface JobDetailInteractor {

    fun search(id: String?)
}