package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyMonthlyRateDto(
    val alias: String,
    val code: String? = null,
    val rate: Double,
    val min: Double? = null, // TODO Will be non nullable in future API releases
    val max: Double? = null, // TODO Will be non nullable in future API releases
)
