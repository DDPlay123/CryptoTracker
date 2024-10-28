package mai.project.cryptotracker.di

import io.ktor.client.engine.cio.CIO
import mai.project.cryptotracker.core.data.networking.HttpClientFactory
import mai.project.cryptotracker.crypto.data.networking.RemoteCoinDataSource
import mai.project.cryptotracker.crypto.domain.CoinDataSource
import mai.project.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }

//    single<CoinDataSource> { RemoteCoinDataSource(get()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

//    viewModel { CoinListViewModel(get()) }
    viewModelOf(::CoinListViewModel)
}