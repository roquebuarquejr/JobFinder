package br.com.brunohensel.roquebuarque.jobfinder.feature.list.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import br.com.brunohensel.roquebuarque.jobfinder.R
import br.com.brunohensel.roquebuarque.jobfinder.application.di.ActivityComponent
import br.com.brunohensel.roquebuarque.jobfinder.base.BaseActivity
import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.adapter.JobListAdapter
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListState
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.Success
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.presentation.JobDetailActivity
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.presentation.JobDetailActivity.Companion.KEY_JOB_ID
import kotlinx.android.synthetic.main.activity_joblist.*

/**
 * Activity to display job list
 */
class JobListActivity : BaseActivity<JobListState, JobListViewModel>() {

    private val adapter by lazy { JobListAdapter(::clickListerJobList) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joblist)
        viewModel
            .fetchState()
            .subscribe(::updateState)
            .also {
                compositeDisposable.add(it)
            }
    }

    private fun updateState(state: JobListState) {
        when (state) {
            is Success -> showList(state.list)
        }
    }

    private fun showList(list: List<JobData>) {
        adapter.submitList(list)
        rvJobList.adapter = adapter
    }

    private fun clickListerJobList(jobId: String) {
        startActivity(JobDetailActivity.start(this, jobId))
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }

    override fun onInject(component: ActivityComponent) {
        component.injectJobListActivity(this)
    }
}