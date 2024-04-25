package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyLatestRatesDto(
    val code: String,
    val title: String,
    val rates: List<CurrencyLatestRateDto>
)

