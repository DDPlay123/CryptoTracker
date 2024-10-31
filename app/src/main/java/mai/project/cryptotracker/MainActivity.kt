package mai.project.cryptotracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mai.project.cryptotracker.core.navigation.AdaptiveCoinListDetailPane
import mai.project.cryptotracker.core.presentation.util.ObserveAsEvents
import mai.project.cryptotracker.core.presentation.util.toString
import mai.project.cryptotracker.crypto.presentation.coin_detail.CoinDetailScreen
import mai.project.cryptotracker.crypto.presentation.coin_list.CoinListEvent
import mai.project.cryptotracker.crypto.presentation.coin_list.CoinListScreen
import mai.project.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import mai.project.cryptotracker.ui.theme.CryptoTrackerTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdaptiveCoinListDetailPane(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}