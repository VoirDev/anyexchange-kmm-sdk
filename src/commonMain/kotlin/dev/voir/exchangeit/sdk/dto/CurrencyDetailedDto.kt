package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyDetailedDto(
    val alias: String,
    val title: String,
    val code: String? = null,
    val isoNumeric: String? = null,
    val titleOrigin: String? = null,
    val crypto: Boolean,
    val obsolete: Boolean,
    val symbol: String? = null,
    val year: Int? = null,
    val url: String? = null,
    val popular: Boolean,
    val rating: Int? = null,
    val hasRates: Boolean,
    val description: String? = null,
    val localizedDescription: Map<String, String>,
    val centralBanks: List<CentralBankDto>
)
