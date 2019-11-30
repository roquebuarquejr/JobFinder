package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailViewModel

import br.com.brunohensel.roquebuarque.jobfinder.data.JobState
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailInteractor.JobDetailInteractor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io

class JobDetailViewModel(val interactor: JobDetailInteractor) {

    fun fetchJobDetailData(): Observable<JobState> =
        interactor
            .getJobDescriptionData()
            .observeOn(mainThread())
            .subscribeOn(io())
            .doOnError {
                it.printStackTrace()
            }
}