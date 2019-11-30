package br.com.brunohensel.roquebuarque.jobfinder.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.brunohensel.roquebuarque.jobfinder.R

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
