package mai.project.cryptotracker.crypto.presentation.coin_list

import mai.project.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {

    data class Error(val error: NetworkError): CoinListEvent
}