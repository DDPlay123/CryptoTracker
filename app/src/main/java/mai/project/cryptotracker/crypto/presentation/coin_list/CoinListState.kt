package mai.project.cryptotracker.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import mai.project.cryptotracker.crypto.presentation.model.CoinUi

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)
