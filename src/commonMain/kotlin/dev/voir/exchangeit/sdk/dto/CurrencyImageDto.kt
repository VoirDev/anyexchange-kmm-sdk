package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyImageDto(
    @SerialName("16")
    val size16: String?,

    @SerialName("32")
    val size32: String?,

    @SerialName("64")
    val size64: String?,

    @SerialName("128")
    val size128: String?,

    @SerialName("256")
    val size256: String?,

    @SerialName("512")
    val size512: String?,

    @SerialName("1024")
    val size1024: String?,

    @SerialName("svg")
    val svg: String?,
)
