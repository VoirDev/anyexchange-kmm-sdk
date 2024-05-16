package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class RatesDto(
    val rates: Map<String, List<CurrencyLatestRateDto>>
)
