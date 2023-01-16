package com.example.sample_jetpack_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel(){
    private var _apiResponse : MutableLiveData<NetworkResult<DataResponse>> = MutableLiveData()
    val apiResponse : LiveData<NetworkResult<DataResponse>> = _apiResponse

    init {
        getDemoAPIResponse()
    }

    private fun getDemoAPIResponse(){
        viewModelScope.launch {
            repository.getSampleDataFromApi().collect{ it ->
                _apiResponse.value = it
            }
        }
    }

}