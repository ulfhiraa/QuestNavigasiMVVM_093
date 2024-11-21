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
import com.example.pam_meet7.ui.view.FormMahasiswaView
import com.example.pam_meet7.ui.viewmodel.MahasiswaViewModel

enum class Halaman{ // untuk menghandle halaman
    Formulir,
    Detail
}

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel()
){
    val uiState by viewModel.uiState.collectAsState()

    NavHost(navController = navController, startDestination = Halaman.Formulir.name ) {
        composable(route = Halaman.Formulir.name) // isinya adalah view formulir.
        {
            val konteks = LocalContext.current
            FormMahasiswaView (listJK =  DataJK.listJK.map { id ->
                konteks.resources.getString(
                    id
                )
            },
                    onSubmitClicked = {}
            )
        }
    }
}