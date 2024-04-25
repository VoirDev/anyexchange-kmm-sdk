package dev.voir.exchangeit.sdk

import dev.voir.exchangeit.sdk.dto.*
import dev.voir.exchangeit.sdk.error.ExchangeItSDKError
import dev.voir.exchangeit.sdk.error.ExchangeItSDKException
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json


private val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
    prettyPrint = true
}

class ExchangeItSDK(engine: HttpClientEngine) : IExchangeItSDK {
    private val client = HttpClient(engine) {
        defaultRequest {
            url.protocol = URLProtocol.HTTPS
            url.host = API_HOST
            url.path(API_BASE_PATH, url.encodedPath)
        }
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
        /*
        install(Logging) {
            logger = Logger.DEFAULT
        }
         */
    }.apply {
        sendPipeline.intercept(HttpSendPipeline.Before) {
            try {
                proceed()
            } catch (e: Throwable) {
                throw ExchangeItSDKException(e)
            }
        }
    }

    override suspend fun getCurrencies(
        crypto: Boolean?,
        search: String?,
        withObsolete: Boolean?
    ): ListDto<CurrencyDto> {
        return client.get("v1/currencies") {
            parameter("crypto", crypto)
            parameter("search", search)
            parameter("withObsolete", withObsolete)
        }.bodyOrThrow()
    }

    override suspend fun getCurrencyDetailed(code: String): DataDto<CurrencyDetailedDto> {
        return client.get("v1/currencies/${code}").bodyOrThrow()
    }

    override suspend fun getLatestRates(code: String, forCodes: List<String>?): DataDto<CurrencyLatestRatesDto> {
        return client.get("v1/currencies/${code}/latest") {
            parameter("for", forCodes)
        }.bodyOrThrow()
    }

    override suspend fun getLatestRates(codes: List<String>): DataDto<RatesDto> {
        return client.get("v1/rates/latest") {
            parameter("codes", codes.joinToString(","))
        }.bodyOrThrow()
    }


    override suspend fun getHistoricalRates(
        code: String,
        date: String,
        forCodes: List<String>?
    ): DataDto<CurrencyRateByDateDto> {
        return client.get("v1/currencies/${code}/historical") {
            parameter("date", date)
            parameter("for", forCodes)
        }.bodyOrThrow()
    }

    override suspend fun getHistoricalRates(
        code: String,
        start: String,
        end: String,
        forCodes: List<String>?
    ): DataDto<CurrencyHistoricalRatesDto> {
        return client.get("v1/currencies/${code}/range") {
            parameter("start", start)
            parameter("end", end)
            parameter("for", forCodes)
        }.bodyOrThrow()
    }

    override suspend fun getMonthlyRates(
        code: String,
        start: String,
        end: String,
        forCodes: List<String>?
    ): DataDto<CurrencyMonthlyRatesDto> {
        return client.get("v1/currencies/${code}/monthly") {
            parameter("start", start)
            parameter("end", end)
            parameter("for", forCodes)
        }.bodyOrThrow()
    }

    override suspend fun getSources(): ListDto<SourceDto> {
        return client.get("v1/sources") { }.bodyOrThrow()
    }

    override suspend fun getSource(alias: String): DataDto<SourceDto> {
        return client.get("v1/sources/${alias}") { }.bodyOrThrow()
    }

    private suspend inline fun <reified T> HttpResponse.bodyOrThrow(): T {
        return if (status == HttpStatusCode.OK) {
            body()
        } else {
            val bodyText = bodyAsText()
            val bodyError = try {
                json.decodeFromString<ErrorDto>(bodyText).error
            } catch (e: SerializationException) {
                null
            }
            throw ExchangeItSDKException(ExchangeItSDKError(status.value, bodyError))
        }
    }

    companion object {
        private const val API_HOST = "api.exchangeit.app"
        private const val API_BASE_PATH = ""
    }
}
