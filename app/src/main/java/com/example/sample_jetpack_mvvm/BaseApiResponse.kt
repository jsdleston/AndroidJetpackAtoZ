package com.example.sample_jetpack_mvvm

import retrofit2.Response

abstract class  BaseApiResponse {

    suspend fun <T> safeApiCall(apiCall : suspend () -> Response<T>): NetworkResult<T>{
        try {
            val response = apiCall.invoke()
            if(response.isSuccessful){
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        }catch (e: Exception){
            return error(e)
        }
    }

    private fun <T> error(message: String): NetworkResult<T> = NetworkResult.Error(message)
}