package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyLatestRatesDto(
    val alias: String,
    val title: String,
    val rates: List<CurrencyLatestRateDto>
)

