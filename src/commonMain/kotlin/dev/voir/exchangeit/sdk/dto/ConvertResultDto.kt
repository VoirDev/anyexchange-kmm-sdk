package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class ConvertResultDto(
    val from: SimpleCurrencyDto,
    val to: SimpleCurrencyDto,
    val amount: Double,
    val result: Double,
    val rate: Double,
    val reverseRate: Double,
)
