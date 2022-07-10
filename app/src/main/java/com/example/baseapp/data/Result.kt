package com.example.baseapp.data

sealed interface Result<out T> {
    data class Success<out T>(val data: T) : Result<T>
    data class Error(val exception: Exception) : Result<Nothing>

    companion object {
        inline fun <reified T> success(data: T): Success<T> = Success(data)

        inline fun <reified T> error(exception: Exception): Error = Error(exception)
    }
}