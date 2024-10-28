package mai.project.cryptotracker.crypto.domain

import mai.project.cryptotracker.core.domain.util.NetworkError
import mai.project.cryptotracker.core.domain.util.Result

interface CoinDataSource {

    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}