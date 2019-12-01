package br.com.brunohensel.roquebuarque.jobfinder.list

import br.com.brunohensel.roquebuarque.jobfinder.RxImmediateSchedulerRule
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.Failure
import br.com.brunohensel.roquebuarque.jobfinder.feature.list.domain.Success

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class JobListViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule =
        RxImmediateSchedulerRule()


    /**
     * Should call getJobList and return Success State
     */
    @Test
    fun `when call getJobList and return success state`(){
        jobListViewModelTestStart{
            mockState(Success(getMockJobList()))
            getJobList()
            assertVerifyValues()
        }
    }

    @Test
    fun `when call getJobList and return failure state`(){
        jobListViewModelTestStart{
            mockState(Failure("my custom message"))
            getJobList()
            assertVerifyValues()
        }
    }
}