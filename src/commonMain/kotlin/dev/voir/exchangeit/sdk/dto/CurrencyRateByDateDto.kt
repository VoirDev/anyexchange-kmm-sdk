package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyRateByDateDto(
    val alias: String,
    val code: String? = null,
    val title: String,
    val date: String,
    val rates: List<SimpleCurrencyRateDto>
)
