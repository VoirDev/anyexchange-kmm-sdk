package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class SimpleCurrencyDto(
    val alias: String,
    val code: String? = null,
    val title: String,
)
