package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class SimpleCurrencyRateDto(
    val alias: String,
    val code: String? = null,
    val rate: Double
)
