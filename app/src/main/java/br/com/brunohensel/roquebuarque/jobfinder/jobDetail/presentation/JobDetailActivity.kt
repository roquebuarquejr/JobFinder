package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.presentation

import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import br.com.brunohensel.roquebuarque.jobfinder.R
import br.com.brunohensel.roquebuarque.jobfinder.application.di.ActivityComponent
import br.com.brunohensel.roquebuarque.jobfinder.base.BaseActivity
import br.com.brunohensel.roquebuarque.jobfinder.data.JobDetailState
import br.com.brunohensel.roquebuarque.jobfinder.data.JobFailure
import br.com.brunohensel.roquebuarque.jobfinder.data.JobSuccess
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailViewModel.JobDetailViewModel
import kotlinx.android.synthetic.main.activity_job_detail.*

class JobDetailActivity : BaseActivity<JobDetailState, JobDetailViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)


        run {
            viewModel
                .fetchState()
                .subscribe(::renderState)
                .also { compositeDisposable.add(it) }
        }

    }

    private fun renderState(state: JobDetailState) {
        when (state) {
            is JobSuccess -> renderSuccessState(state)
            is JobFailure -> Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun renderSuccessState(state: JobSuccess) {
        txtTypeJobHeader.text = state.data.type
        txtContryHeader.text = state.data.location
        txtTitle.text = state.data.title
        txtDescription.text = (Html.fromHtml(state.data.description))
        txtDescription.movementMethod = ScrollingMovementMethod()

    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }

    override fun onInject(component: ActivityComponent) {
        component.injectJobDetailActivity(this)
    }
}
