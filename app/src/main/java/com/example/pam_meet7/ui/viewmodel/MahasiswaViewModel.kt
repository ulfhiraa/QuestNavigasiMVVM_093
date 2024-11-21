package com.example.pam_meet7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pam_meet7.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel(){ // class turunan dari View Model
    // REQUEST
    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState: StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(listDM: List<String>){
        _uiState.update { dataMhs ->
            dataMhs.copy(
                nama = listDM[0], // listDM di kanan, isi datanya berasal dari data inputan
                gender = listDM[1],
                alamat = listDM[2]
            )
        }
    }
}