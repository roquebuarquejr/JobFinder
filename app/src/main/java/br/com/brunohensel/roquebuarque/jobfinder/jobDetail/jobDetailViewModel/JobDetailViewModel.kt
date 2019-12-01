package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailViewModel

import br.com.brunohensel.roquebuarque.jobfinder.base.BaseViewModel
import br.com.brunohensel.roquebuarque.jobfinder.data.JobDetailState
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailInteractor.JobDetailInteractor
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailInteractor.JobDetailInteractorImpl
import javax.inject.Inject

class JobDetailViewModel @Inject constructor(interactor: JobDetailInteractorImpl) :
    BaseViewModel<JobDetailState>(interactor.observable), JobDetailInteractor by interactor