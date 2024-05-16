package dev.voir.exchangeit.sdk.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SourceTypeDto {
    @SerialName("central_bank")
    CentralBank,
    @SerialName("bank")
    Bank,
    @SerialName("market")
    Market,
    @SerialName("crypto_market")
    CryptoMarket,
    @SerialName("free_source")
    FreeSource,
    @SerialName("api")
    Api,
    @SerialName("unknown")
    Unknown,
    @SerialName("secret")
    Secret,
}
