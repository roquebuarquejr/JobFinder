package br.com.brunohensel.roquebuarque.jobfinder.data.model

import com.google.gson.annotations.SerializedName
/**
 * Data class to store job information
 */

data class JobData(
    val id: String,
    val type: String,
    val url: String,
    @SerializedName("created_at")
    val createdAt: String,
    val company: String,
    val companyUrl: String,
    val location: String,
    val title: String,
    val description: String,
    val howToApply: String,
    @SerializedName("company_logo")
    val companyLogo: String
)

