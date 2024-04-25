package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyDetailedDto(
    val code: String,
    val title: String,
    val localizedTitle: Map<String, String>,
    val description: String? = null,
    val localizedDescription: Map<String, String>,
    val crypto: Boolean,
    val obsolete: Boolean,
    val symbol: String? = null,
    val year: String? = null,
    val url: String? = null,
    val popular: Boolean,
    val centralBanks: List<CentralBankDto>
)
