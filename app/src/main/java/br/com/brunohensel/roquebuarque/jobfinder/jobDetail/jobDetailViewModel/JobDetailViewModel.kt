package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailViewModel

import br.com.brunohensel.roquebuarque.jobfinder.base.BaseViewModel
import br.com.brunohensel.roquebuarque.jobfinder.data.JobDetailState
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailInteractor.JobDetailInteractor
import br.com.brunohensel.roquebuarque.jobfinder.utils.applySchedulers
import javax.inject.Inject

class JobDetailViewModel @Inject constructor(private  val interactor: JobDetailInteractor) :
    BaseViewModel<JobDetailState>(interactor.observable) {

    fun fetchJobDetail(jobId: String?) =
        interactor.getJobDescriptionData(jobId)
            .applySchedulers()
}