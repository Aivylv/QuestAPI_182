package com.example.activity8_questapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.activity8_questapi.modeldata.DataSiswa
import com.example.activity8_questapi.repositori.RepositoryDataSiswa
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface StatusUiSiswa {
    data class Success(val siswa: List<DataSiswa> = listOf()) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}

class HomeViewModel(private val repositoryDataSiswa: RepositoryDataSiswa):
    ViewModel() {
    var listSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
        private set
