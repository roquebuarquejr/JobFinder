package br.com.brunohensel.roquebuarque.jobfinder.feature.list.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.brunohensel.roquebuarque.jobfinder.data.model.Job

/**
 *  Class to compare differences btw [Job]
 */
class JobDiff : DiffUtil.ItemCallback<Job>() {

    override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean {
        return oldItem == newItem
    }
}