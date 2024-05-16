package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.Serializable

@Serializable
data class SourceDto(
    val alias: String,
    val title: String,
    val type: SourceTypeDto,
    val api: Boolean
)
