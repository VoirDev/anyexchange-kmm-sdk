package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyLatestRateDto(
    val alias: String,
    val code: String? = null,
    val rate: Double,
    val date: String,
    val fluctuation: Double
)
