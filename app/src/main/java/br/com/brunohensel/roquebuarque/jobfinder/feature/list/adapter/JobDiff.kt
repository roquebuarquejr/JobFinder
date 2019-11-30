package br.com.brunohensel.roquebuarque.jobfinder.feature.list.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.brunohensel.roquebuarque.jobfinder.data.model.JobData

/**
 *  Class to compare differences btw [JobData]
 */
class JobDiff : DiffUtil.ItemCallback<JobData>() {

    override fun areItemsTheSame(oldItem: JobData, newItem: JobData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: JobData, newItem: JobData): Boolean {
        return oldItem == newItem
    }
}