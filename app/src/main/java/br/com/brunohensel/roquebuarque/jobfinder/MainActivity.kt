package br.com.brunohensel.roquebuarque.jobfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.brunohensel.roquebuarque.jobfinder.data.JobApi
import br.com.brunohensel.roquebuarque.jobfinder.data.providers.retrofit
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val request = retrofit.create(
            JobApi::class.java)

        request
            .getJobPositions()
            .observeOn(mainThread())
            .subscribeOn(io())
            .doOnError {
                it.printStackTrace()
            }*/


    }
}
