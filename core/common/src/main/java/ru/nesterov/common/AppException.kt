package ru.nesterov.common

open class AppException(
    message: String = "",
    cause: Throwable? = null,
) : Exception(message, cause)

class ConnectionException(cause: Throwable) : AppException(cause = cause)

open class BackendException(
    val code: Int,
    message: String
) : AppException(message)

class ParseBackendResponseException(
    cause: Throwable
) : AppException(cause = cause)