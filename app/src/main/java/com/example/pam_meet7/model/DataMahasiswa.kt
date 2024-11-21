package com.example.pam_meet7.model

data class DataMahasiswa(
    val nama: String = "",
    val gender: String = "",
    val alamat: String = "",
    val NIM: String = ""
) // kelas data untuk menyimpan data nama, gender, alamat dan NIM
// default "" akan otomatis diisi dengan string kosong.