package dev.voir.exchangeit.sdk.dto

data class CurrencyRateByDateDto(
    val code: String,
    val title: String,
    val date: String,
    val rates: List<SimpleCurrencyRateDto>
)
