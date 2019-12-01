package br.com.brunohensel.roquebuarque.jobfinder.jobDetail.presentation

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.drawToBitmap
import br.com.brunohensel.roquebuarque.jobfinder.R
import br.com.brunohensel.roquebuarque.jobfinder.application.di.ActivityComponent
import br.com.brunohensel.roquebuarque.jobfinder.base.BaseActivity
import br.com.brunohensel.roquebuarque.jobfinder.base.BaseState
import br.com.brunohensel.roquebuarque.jobfinder.data.JobDetailState
import br.com.brunohensel.roquebuarque.jobfinder.data.JobFailure
import br.com.brunohensel.roquebuarque.jobfinder.data.JobSuccess
import br.com.brunohensel.roquebuarque.jobfinder.jobDetail.jobDetailViewModel.JobDetailViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_job_detail.*

class JobDetailActivity : BaseActivity<JobDetailState, JobDetailViewModel>() {

    companion object {
        const val KEY_JOB_ID = "JobId"

        fun start(activity: AppCompatActivity, jobId: String): Intent {
            val intent = Intent(activity, JobDetailActivity::class.java)
            intent.putExtra(KEY_JOB_ID, jobId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)
        viewModel.search(intent.getStringExtra(KEY_JOB_ID))

    }

    private fun renderSuccessState(state: JobSuccess) {
        Glide.with(this)
            .asBitmap()
            .load(state.data.companyLogo)
            .into(imgCompanyLogo)
        /*.listener(object : RequestListener<Bitmap>{
          override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?,
              isFirstResource: Boolean
          ): Boolean {
              return false
          }
          override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap>?,
              dataSource: DataSource?,
              isFirstResource: Boolean
          ): Boolean {
              imgCompanyLogo.drawToBitmap()
             Palette.from(imgCompanyLogo.drawToBitmap()).generate { palette ->
                  val bgColor =
                      palette?.getDominantColor(ContextCompat.getColor(this@JobDetailActivity, android.R.color.white))
                  val titleColor =
                      palette?.getLightVibrantColor(ContextCompat.getColor(this@JobDetailActivity, android.R.color.black))
                  collapsToolbar.setContentScrimColor(bgColor!!)
                  collapsToolbar.setCollapsedTitleTextColor(titleColor!!)
                  window.statusBarColor = bgColor
              }

              return true
          }

      })*/

        //collapsToolbar.title = state.data.title
        //collapsToolbar.setExpandedTitleColor(resources.getColor(android.R.color.transparent))
        txtJobDescription.text = (Html.fromHtml(state.data.description))
        txtJobDescription.movementMethod = ScrollingMovementMethod()
        /*collapsToolbar.setContentScrimColor(Color.WHITE)
        collapsToolbar.setCollapsedTitleTextColor(Color.BLACK)*/


    }

    override fun onInject(component: ActivityComponent) {
        component.injectJobDetailActivity(this)
    }

    override fun renderState(state: BaseState) {
        when (state) {
            is JobSuccess -> renderSuccessState(state)
            is JobFailure -> Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
        }
    }

}
