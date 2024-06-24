package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyHistoricalRatesDto(
    val alias: String,
    val code: String? = null,
    val title: String,
    val start: String,
    val end: String,
    val historical: List<CurrencyHistoricalRateDto>
)
