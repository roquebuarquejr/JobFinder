package br.com.brunohensel.roquebuarque.jobfinder.application.di

import br.com.brunohensel.roquebuarque.jobfinder.feature.list.presentation.JobListActivity
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.presentation.JobDetailActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun injectJobListActivity(jobListActivity: JobListActivity)
    fun injectJobDetailActivity(jobDetailActivity: JobDetailActivity)
}