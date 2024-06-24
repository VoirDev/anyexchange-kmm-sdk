package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyLatestRatesDto(
    val alias: String,
    val code: String? = null,
    val title: String,
    val rates: List<CurrencyLatestRateDto>
)

