package br.com.brunohensel.roquebuarque.jobfinder.data.model

data class JobData(
    val id: String,
    val type: String,
    val url: String,
    val createdAt: String,
    val company: String,
    val companyUrl: String,
    val location: String,
    val title: String,
    val description: String,
    val howToApply: String,
    val companyLogo: String
)
