package mai.project.cryptotracker.crypto.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import mai.project.cryptotracker.core.data.networking.constructUrl
import mai.project.cryptotracker.core.data.networking.safeCall
import mai.project.cryptotracker.core.domain.util.NetworkError
import mai.project.cryptotracker.core.domain.util.Result
import mai.project.cryptotracker.core.domain.util.map
import mai.project.cryptotracker.crypto.data.mappers.toCoin
import mai.project.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import mai.project.cryptotracker.crypto.domain.Coin
import mai.project.cryptotracker.crypto.domain.CoinDataSource

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(urlString = constructUrl("/assets"))
        }.map { res-> res.data.map { it.toCoin() } }
    }
}