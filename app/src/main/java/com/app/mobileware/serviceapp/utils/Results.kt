package com.app.mobileware.serviceapp.utils

sealed class Results<out T> {
    data class Success<out T>(val data: T) : Results<T>()
    data class Failure(val exception: Exception) : Results<Nothing>()

    inline fun success(action: (Success<T>) -> Unit): Results<T> {
        if (this is Success) {
            action(this)
        }
        return this
    }

    inline fun failure(action: (Failure) -> Unit): Results<T> {
        if (this is Failure) {
            action(this)
        }
        return this
    }
}