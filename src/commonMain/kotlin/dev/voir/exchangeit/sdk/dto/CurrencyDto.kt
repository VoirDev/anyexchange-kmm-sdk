package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyDto(
    val code: String,
    val title: String,
    val localizedTitle: Map<String, String>,
    val crypto: Boolean,
    val obsolete: Boolean,
    val symbol: String? = null,
    val year: Int? = null,
    val url: String? = null,
    val popular: Boolean
)
