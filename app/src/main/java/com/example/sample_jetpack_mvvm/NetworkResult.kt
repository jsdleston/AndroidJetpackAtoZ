package com.example.sample_jetpack_mvvm

sealed class NetworkResult<out T>(val data : T? = null, val error: String? = null ) {
    class Loading<T>: NetworkResult<T>()
    class Success<T>(data: T?): NetworkResult<T>(data)
    class Error<T>(error: String): NetworkResult<T>(error = error)
}