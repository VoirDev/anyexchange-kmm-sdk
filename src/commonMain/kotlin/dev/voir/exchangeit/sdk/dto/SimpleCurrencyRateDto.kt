package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class SimpleCurrencyRateDto(
    val code: String,
    val rate: Double
)
