package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailViewModel

import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailInteractor.JobDetailInteractor
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io

class JobDetailViewModel(private val interactor: JobDetailInteractor) {

    fun fetchJobDetailData() =
        interactor
            .getJobDescriptionData()
            .observeOn(mainThread())
            .subscribeOn(io())
            .doOnError {
                it.printStackTrace()
            }
}