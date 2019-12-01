package br.com.brunohensel.roquebuarque.jobfinder.data

import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Api class for job requests
 */
interface JobApi {

    @GET("positions.json")
    fun getJobPositions(): Observable<List<JobData>>

    @GET("positions/{job_id}.json")
    fun getPositionDetail(@Path(value = "job_id") jobId: String?): Observable<JobData>

}