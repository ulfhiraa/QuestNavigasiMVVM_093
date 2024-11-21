package com.example.pam_meet7.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pam_meet7.model.DataMahasiswa

@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    )
{
    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat)
    )

    Column (){
        listDataMhs.forEach { items ->
            CardSection(
                judulParam = items.first,
                isiParam = items.second
            )
        }
    }
}

@Composable
fun CardSection(judulParam:String, isiParam:String){
    Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(8.dp)) {
        // horizontal alignment start untuk memulai tulisan secara horizontal dari kiri ke kanan

        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = judulParam, modifier = Modifier.weight(2f)) // weight untuk mengatur space isi data
            Text(text = " : ", modifier = Modifier.weight(1f))
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f))
        }
    }
}