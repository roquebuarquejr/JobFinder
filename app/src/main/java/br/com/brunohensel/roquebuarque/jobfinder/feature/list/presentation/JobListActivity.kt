package br.com.brunohensel.roquebuarque.jobfinder.feature.list.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.brunohensel.roquebuarque.jobfinder.R
import br.com.brunohensel.roquebuarque.jobfinder.data.model.Job
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.adapter.JobListAdapter
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListInteractorImpl
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListState
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.Success
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_joblist.*

/**
 * Activity to display job list
 */
class JobListActivity : AppCompatActivity() {

    private val viewModel by lazy { JobListViewModel(JobListInteractorImpl()) }
    private val adapter by lazy { JobListAdapter(::clickListerJobList) }
    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joblist)

        viewModel
            .getJobList()
            .subscribe (::updateState)
            .also {
                compositeDisposable.add(it)
            }
    }

    private fun updateState(state:JobListState){
        when(state){
            is Success -> showList(state.list)
        }

    }

    private fun showList(list: List<Job>) {
        adapter.submitList(list)
        rvJobList.adapter = adapter
    }

    private fun clickListerJobList(jobId: String) {
        //TODO OPEN DETAIL ACTIVITY
        Toast.makeText(this, jobId, Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }
}