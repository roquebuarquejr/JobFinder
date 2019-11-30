package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.presentation

import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.brunohensel.roquebuarque.jobfinder.R
import br.com.brunohensel.roquebuarque.jobfinder.data.JobFailure
import br.com.brunohensel.roquebuarque.jobfinder.data.JobState
import br.com.brunohensel.roquebuarque.jobfinder.data.JobSuccess
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailInteractor.JobDetailInteractor
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailViewModel.JobDetailViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_job_detail.*

class JobDetailActivity : AppCompatActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)


        val viewModel by lazy { JobDetailViewModel(JobDetailInteractor()) }
        run {
            viewModel
                .fetchJobDetailData()
                .subscribe(::renderState)
                .also { compositeDisposable.add(it) }
        }

    }

    private fun renderState(state: JobState) {
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
}
