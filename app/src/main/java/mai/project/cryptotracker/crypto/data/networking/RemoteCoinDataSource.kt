package mai.project.cryptotracker.crypto.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import mai.project.cryptotracker.core.data.networking.constructUrl
import mai.project.cryptotracker.core.data.networking.safeCall
import mai.project.cryptotracker.core.domain.util.NetworkError
import mai.project.cryptotracker.core.domain.util.Result
import mai.project.cryptotracker.core.domain.util.map
import mai.project.cryptotracker.crypto.data.mappers.toCoin
import mai.project.cryptotracker.crypto.data.mappers.toCoinPrice
import mai.project.cryptotracker.crypto.data.networking.dto.CoinHistoryDto
import mai.project.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import mai.project.cryptotracker.crypto.domain.Coin
import mai.project.cryptotracker.crypto.domain.CoinDataSource
import mai.project.cryptotracker.crypto.domain.CoinPrice
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(urlString = constructUrl("/assets"))
        }.map { res-> res.data.map { it.toCoin() } }
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryDto> {
            httpClient.get(urlString = constructUrl("/assets/$coinId/history")) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { res -> res.data.map { it.toCoinPrice() } }
    }
}