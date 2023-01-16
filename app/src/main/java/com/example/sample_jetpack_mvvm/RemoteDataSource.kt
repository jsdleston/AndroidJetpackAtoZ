package com.example.sample_jetpack_mvvm

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getGlobalAPIList() = apiService.getSampleData()
}