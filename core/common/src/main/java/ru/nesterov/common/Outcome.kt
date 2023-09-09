package ru.nesterov.common

sealed class Outcome<T> {

    class Success<T>(
        val value: T
    ) : Outcome<T>()

    class Error<T>(
        val error: Throwable
    ) : Outcome<T>()

    class Pending<T> : Outcome<T>()
}
