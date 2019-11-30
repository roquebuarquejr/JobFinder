package br.com.brunohensel.roquebuarque.jobfinder.data

import br.com.brunohensel.roquebuarque.jobfinder.data.model.Job
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

/**
 * Api class for job requests
 */
interface JobApi {

    @GET("positions.json")
    fun getJobPositions(): Observable<List<Job>>

    @GET("positions/99269eb4-77fa-4153-b9bd-18116cc44bc3.json")
    fun <T> getPositionDetail(): Single<Response<T>>

}