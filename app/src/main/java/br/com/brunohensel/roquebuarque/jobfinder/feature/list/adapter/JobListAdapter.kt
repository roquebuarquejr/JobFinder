package br.com.brunohensel.roquebuarque.jobfinder.feature.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.brunohensel.roquebuarque.jobfinder.R
import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_job.view.*

/**
 * Adapter to handle job list
 */
class JobListAdapter(private val onClickListener: (String) -> Unit): ListAdapter<JobData, JobListAdapter.JobViewHolder>(JobDiff())  {

    override fun onBindViewHolder(
        holder: JobViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position), onClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        return JobViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_job, parent, false))
    }

    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            data: JobData,
            onClickListener: (String) -> Unit
        ) {
            with(itemView) {
                itemView.setOnClickListener {
                    onClickListener(data.id)
                }
                txtTitleItemJob.text = data.title
                Glide.with(context)
                    .load(data.companyLogo)
                    .into(imgCompanyItemJob)
            }
        }
    }
}