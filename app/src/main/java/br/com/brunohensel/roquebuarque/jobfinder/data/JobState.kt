package br.com.brunohensel.roquebuarque.jobfinder.data

import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData

sealed class JobState
data class JobSuccess (val data: JobData): JobState()
data class JobFailure (val message: String): JobState()