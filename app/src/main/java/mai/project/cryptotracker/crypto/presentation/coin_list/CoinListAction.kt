package mai.project.cryptotracker.crypto.presentation.coin_list

import mai.project.cryptotracker.crypto.presentation.model.CoinUi

sealed interface CoinListAction {

    data class OnCoinClick(val coinUi: CoinUi) : CoinListAction

    data object OnRefresh : CoinListAction
}