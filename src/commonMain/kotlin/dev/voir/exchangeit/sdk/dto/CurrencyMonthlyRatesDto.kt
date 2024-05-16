package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyMonthlyRatesDto(
    val alias: String,
    val title: String,
    val start: String,
    val end: String,
    val monthly: List<CurrencyMonthRateDto>
)
