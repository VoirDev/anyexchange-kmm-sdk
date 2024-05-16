package dev.voir.exchangeit.sdk

import dev.voir.exchangeit.sdk.dto.*

interface IExchangeItSDK {
    suspend fun getCurrencies(crypto: Boolean? = null, search: String? = null, withObsolete: Boolean? = null, withNoRates: Boolean? = null): ListDto<CurrencyDto>

    suspend fun getCurrencyDetailed(alias: String): DataDto<CurrencyDetailedDto>

    suspend fun getLatestRates(alias: String, forAliases: List<String>? = null): DataDto<CurrencyLatestRatesDto>

    suspend fun getLatestRates(aliases: List<String>): DataDto<RatesDto>

    suspend fun getHistoricalRates(
        alias: String,
        date: String,
        forAliases: List<String>? = null
    ): DataDto<CurrencyRateByDateDto>

    suspend fun getHistoricalRates(
        alias: String,
        start: String,
        end: String,
        forAliases: List<String>? = null
    ): DataDto<CurrencyHistoricalRatesDto>

    suspend fun getMonthlyRates(
        alias: String,
        start: String,
        end: String,
        forAliases: List<String>? = null
    ): DataDto<CurrencyMonthlyRatesDto>

    suspend fun getSources(): ListDto<SourceDto>

    suspend fun getSource(alias: String): DataDto<SourceDto>
}
