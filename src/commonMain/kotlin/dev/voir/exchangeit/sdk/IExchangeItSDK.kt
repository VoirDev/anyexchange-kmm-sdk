package dev.voir.exchangeit.sdk

import dev.voir.exchangeit.sdk.dto.*

interface IExchangeItSDK {
    suspend fun getCurrencies(crypto: Boolean? = null, search: String? = null, withObsolete: Boolean? = null): ListDto<CurrencyDto>

    suspend fun getCurrencyDetailed(code: String): DataDto<CurrencyDetailedDto>

    suspend fun getLatestRates(code: String, forCodes: List<String>? = null): DataDto<CurrencyLatestRatesDto>

    suspend fun getLatestRates(codes: List<String>): DataDto<RatesDto>

    suspend fun getHistoricalRates(
        code: String,
        date: String,
        forCodes: List<String>? = null
    ): DataDto<CurrencyRateByDateDto>

    suspend fun getHistoricalRates(
        code: String,
        start: String,
        end: String,
        forCodes: List<String>? = null
    ): DataDto<CurrencyHistoricalRatesDto>

    suspend fun getMonthlyRates(
        code: String,
        start: String,
        end: String,
        forCodes: List<String>? = null
    ): DataDto<CurrencyMonthlyRatesDto>

    suspend fun getSources(): ListDto<SourceDto>

    suspend fun getSource(alias: String): DataDto<SourceDto>
}
