package br.com.brunohensel.roquebuarque.jobfinder.data.model

import com.google.gson.annotations.SerializedName

/**
 * Data class to store job information
 */
data class Job(
    val id: String,
    val type: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("company_logo")
    val companyLogo: String,
    val company: String,
    val location: String,
    val title: String
)