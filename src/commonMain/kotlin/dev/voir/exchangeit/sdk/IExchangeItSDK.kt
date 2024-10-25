package dev.voir.exchangeit.sdk

import dev.voir.exchangeit.sdk.dto.*

interface IExchangeItSDK {
    suspend fun getCurrencies(
        crypto: Boolean? = null,
        search: String? = null,
        withObsolete: Boolean? = null,
        withNoRates: Boolean? = null
    ): ListDto<CurrencyDto>

    suspend fun getCurrencyDetailed(alias: String): DataDto<CurrencyDetailedDto>

    @Deprecated("Will be replaced", replaceWith = ReplaceWith("getLatestRatesV2"))
    suspend fun getLatestRates(
        alias: String,
        forAliases: List<String>? = null,
        forPopular: Int? = null
    ): DataDto<CurrencyLatestRatesDto>

    suspend fun getLatestRatesV2(
        alias: String,
        forAliases: List<String>? = null,
        forPopular: Int? = null
    ): DataDto<CurrencyLatestRatesDto>

    @Deprecated("Will be replaced", replaceWith = ReplaceWith("getLatestRatesV2"))
    suspend fun getLatestRates(aliases: List<String>): DataDto<RatesDto>

    suspend fun getLatestRatesV2(aliases: List<String>): DataDto<RatesDto>

    @Deprecated("Will be replaced", replaceWith = ReplaceWith("getHistoricalRatesV2"))
    suspend fun getHistoricalRates(
        alias: String,
        date: String,
        forAliases: List<String>? = null,
        forPopular: Int? = null
    ): DataDto<CurrencyRateByDateDto>

    suspend fun getHistoricalRatesV2(
        alias: String,
        date: String,
        forAliases: List<String>? = null,
        forPopular: Int? = null
    ): DataDto<CurrencyRateByDateDto>

    @Deprecated("Will be replaced", replaceWith = ReplaceWith("getHistoricalRatesV2"))
    suspend fun getHistoricalRates(
        alias: String,
        start: String,
        end: String,
        forAliases: List<String>? = null,
        forPopular: Int? = null
    ): DataDto<CurrencyHistoricalRatesDto>

    suspend fun getHistoricalRatesV2(
        alias: String,
        start: String,
        end: String,
        forAliases: List<String>? = null,
        forPopular: Int? = null
    ): DataDto<CurrencyHistoricalRatesDto>

    @Deprecated("Will be replaced", replaceWith = ReplaceWith("getMonthlyRatesV2"))
    suspend fun getMonthlyRates(
        alias: String,
        start: String,
        end: String,
        forAliases: List<String>? = null,
        forPopular: Int? = null
    ): DataDto<CurrencyMonthlyRatesDto>

    suspend fun getMonthlyRatesV2(
        alias: String,
        start: String,
        end: String,
        forAliases: List<String>? = null,
        forPopular: Int? = null
    ): DataDto<CurrencyMonthlyRatesDto>

    suspend fun getSources(): ListDto<SourceDto>

    suspend fun getSource(alias: String): DataDto<SourceDto>

    suspend fun convert(amount: Double, from: String, to: String): DataDto<ConvertResultDto>
}
