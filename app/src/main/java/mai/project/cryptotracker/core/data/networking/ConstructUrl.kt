package mai.project.cryptotracker.core.data.networking

import mai.project.cryptotracker.BuildConfig

/**
 * @see <a href="https://docs.coincap.io/">API 資料來源</a>
 */
fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1)
        else -> BuildConfig.BASE_URL + url
    }
}