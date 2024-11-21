package com.example.pam_meet7

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam_meet7.model.DataJK
import com.example.pam_meet7.ui.view.DetailMahasiswaView
import com.example.pam_meet7.ui.view.FormMahasiswaView
import com.example.pam_meet7.ui.viewmodel.MahasiswaViewModel

enum class Halaman{ // untuk menghandle halaman
    Formulir,
    Detail
}

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
// navHost untuk menampung informasi setiap halaman.
// navHostController untuk mengatur navigasi
){
    val uiState by viewModel.uiState.collectAsState() // untuk menghubungkan data (state) dari viewModel ke UI

    NavHost(navController = navHost, startDestination = Halaman.Formulir.name ) {
        composable(route = Halaman.Formulir.name) // isinya adalah view formulir.
        {
            val konteks = LocalContext.current
            FormMahasiswaView (
                listJK =  DataJK.listJK.map {
                    id -> konteks.resources.getString(id)
            },
                    onSubmitClicked = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(Halaman.Detail.name) // Menggunakan navHost untuk berpindah ke halaman detail
                    }
            )
        }
        composable(route = Halaman.Detail.name){
            DetailMahasiswaView(

            )
        }
    }
}