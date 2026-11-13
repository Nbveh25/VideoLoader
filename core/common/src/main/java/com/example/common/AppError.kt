package com.example.common

sealed interface AppError {
    interface NetworkError: AppError
    class ServerError(code: Int, message: String?): AppError
    interface LocalStorageError: AppError
    class UnknownError(throwable: Throwable?)
}