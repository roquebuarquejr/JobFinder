package br.com.brunohensel.roquebuarque.jobfinder.data

import br.com.brunohensel.roquebuarque.jobfinder.base.BaseState
import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData

sealed class JobDetailState: BaseState
data class JobSuccess (val data: JobData): JobDetailState()
data class JobFailure (val message: String): JobDetailState()