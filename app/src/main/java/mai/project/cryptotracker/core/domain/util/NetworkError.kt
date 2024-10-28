package mai.project.cryptotracker.core.domain.util

enum class NetworkError : Error {

    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTENT,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN;
}