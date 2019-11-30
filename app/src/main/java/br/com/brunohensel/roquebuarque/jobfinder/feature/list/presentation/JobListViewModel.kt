package br.com.brunohensel.roquebuarque.jobfinder.feature.list.presentation

import br.com.brunohensel.roquebuarque.jobfinder.base.BaseViewModel
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListInteractorImpl
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListState
import javax.inject.Inject

class JobListViewModel @Inject constructor(interactor: JobListInteractorImpl) :
    BaseViewModel<JobListState>(interactor.observable)