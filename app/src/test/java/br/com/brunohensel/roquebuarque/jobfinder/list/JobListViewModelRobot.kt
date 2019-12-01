package br.com.brunohensel.roquebuarque.jobfinder.list

import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListInteractorImpl
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.JobListState
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.presentation.JobListViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable.just
import io.reactivex.observers.TestObserver


class JobListViewModelRobot {

    private val interactor: JobListInteractorImpl = mock()
    private lateinit var viewModel: JobListViewModel
    private lateinit var testee: TestObserver<JobListState>
    lateinit var state: JobListState


    fun mockState(state: JobListState) {
        whenever(interactor.observable).thenReturn(just(state))
        viewModel = JobListViewModel(interactor)

        this.state = state
    }

    fun getJobList() {
        testee = viewModel.fetchState().test()
    }

    fun assertVerifyValues() {
        verify(interactor).observable
        testee.assertValue(state)
    }
}

inline fun jobListViewModelTestStart(func: JobListViewModelRobot.() -> Unit) = JobListViewModelRobot()
    .apply { func() }

fun getMockJobList() = listOf(
    JobData(
        id = "jobId",
        type = "Full time",
        url = "",
        createdAt = "22.02.2019",
        company = "company",
        location = "berlin",
        companyUrl = "companyUrl",
        title = "Android Developer",
        description = "Description bla bla bla",
        howToApply = "howTo",
        companyLogo = "companyLog"
    )
)