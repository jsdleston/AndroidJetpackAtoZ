package com.example.sample_jetpack_mvvm

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET(Constants.GET_ENTRIES)
    suspend fun getSampleData(): Response<DataResponse>
}