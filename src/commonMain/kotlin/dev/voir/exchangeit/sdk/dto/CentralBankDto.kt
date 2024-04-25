package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CentralBankDto(
    val alias: String,
    val name: String,
    val url: String? = null
)
