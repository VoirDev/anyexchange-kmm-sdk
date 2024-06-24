package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyFlagDto(
    val default: CurrencyImageDto? = null,
    val square: CurrencyImageDto? = null,
)
