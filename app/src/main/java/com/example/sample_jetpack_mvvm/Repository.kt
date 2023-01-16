package com.example.sample_jetpack_mvvm

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) : BaseApiResponse() {
    suspend fun getSampleDataFromApi(): Flow<NetworkResult<DataResponse>>{
        return flow {
            emit(safeApiCall {
                remoteDataSource.getGlobalAPIList()
            })
        }.catch { ex ->
            NetworkResult.Error<String>(ex.message.toString())
        }.flowOn(Dispatchers.IO)
    }
}