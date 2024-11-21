package com.example.pam_meet7.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

//@Preview(showBackground = true)
// untuk menampilkan tampilan.
// showBackground = true, latar belakang preview akan ditampilkan

@Composable // penanda fungsi UI di Jetpack Compose

        /*
        untuk menyimpan status UI saat rotasi layar atau perubahan konfigurasi lainnya,
        sehingga nilai input tetap terjaga meskipun layar diputar atau aplikasi berhenti sementara.

        mutableStateOf("") digunakan untuk mendeklarasikan variabel yang dapat berubah,
        yang nilainya adalah string kosong pada awalnya.
        */

fun FormMahasiswaView(
    modifier: Modifier = Modifier, // parameter untuk memungkinkan penyesuain tata letak UI, seperti ukuran dan padding.
    listJK: List<String>,
    onSubmitClicked: (MutableList<String>) -> Unit
) {
    var nama by rememberSaveable { mutableStateOf("") }
    // var bisa diubah
    var email by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var NIM by rememberSaveable { mutableStateOf("") }
    var selectedGender by rememberSaveable { mutableStateOf("") }

    val dataMahasiswa: MutableList<String> = mutableListOf(nama, selectedGender, alamat, NIM)

    Column (Modifier.fillMaxSize().padding(16.dp),
// Column digunakan untuk menata elemen secara vertikal (sejajar dalam satu kolom).
// Modifier.fillMaxSize() memastikan tampilan mengisi seluruh ukuran layar.
// padding(16.dp) memberikan ruang sekitar elemen di dalam Column.
// horizontalAlignment = Alignment.CenterHorizontally mengatur elemen-elemen dalam kolom agar rata tengah secara horizontal.

        horizontalAlignment = Alignment.CenterHorizontally) { // layout 1
        OutlinedTextField(
            value = nama, // nilai
            onValueChange = {nama = it}, // ketika data diubah, dia akan muncul disini
            placeholder = { Text("Masukkan nama: ")}, //
            label = { Text("Nama")}, // judulnya
            modifier = Modifier.fillMaxWidth().padding(5.dp) // untuk mengatur selebar layar dengan padding jarak 5dp
        )

        Row(){
            /*
            sebuah perulangan (loop) yang digunakan untuk mengeksekusi blok kode untuk setiap elemen yang ada dalam daftar jenisKelamin.

            forEach adalah fungsi bawaan dalam Kotlin yang digunakan untuk menjalankan kode untuk setiap elemen di dalam koleksi (list, set, dll).
            */
            listJK.forEach { item -> // forEach untuk  Looping melalui daftar jenisKelamin yang berisi dua pilihan, yaitu "Laki-laki" dan "Perempuan".
                Row (verticalAlignment = Alignment.CenterVertically) // untuk mengatur posisi secara vertikal dan ditengah
                { RadioButton(selected = selectedGender == item, // radio button untuk setiap item.
                    onClick = {
                        selectedGender = item // ketika di klik nilai selectedGender akan berubah sesuai dengan pilihan.
                    })
                    Text(item) // menampilkan teks sesuai dengan pilihan, yaitu; laki-laki dan perempuan.
                }
            }
        }
        /*
        jenisKelamin adalah daftar yang berisi dua pilihan: "Laki-laki" dan "Perempuan".
        RadioButton digunakan untuk memilih salah satu dari dua pilihan jenis kelamin.
        selected = selectedGender == item memastikan bahwa radio button yang sesuai dengan nilai selectedGender akan dicentang.
        onClick = { selectedGender = item } mengubah nilai selectedGender ketika pilihan radio button diklik.
        */
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan email: ")},
            label = { Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        /*
        Input untuk email, alamat, dan noHP menggunakan komponen OutlinedTextField, hampir sama dengan input untuk nama.
        Pada email, keyboardOptions diatur agar keyboard yang muncul adalah keyboard untuk memasukkan email (dengan karakter seperti @ dan .com).
        */
        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan alamat: ")},
            label = { Text("Alamat")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = NIM,
            onValueChange = {NIM = it},
            placeholder = { Text("Masukkan NIM: ")},
            label = { Text("NIM")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Button(onClick = {onSubmitClicked(dataMahasiswa)})
        // Button adalah tombol yang, ketika diklik, akan menyimpan nilai-nilai yang dimasukkan ke dalam variabel namaUser, emailUser, alamatUser, noHPUser, dan selectedGenderUser.
        {
            Text("Simpan")
        }
    }
}



/*
Aplikasi ini membuat tampilan formulir dengan input untuk nama,
email, alamat, nomor HP, dan jenis kelamin. Setelah pengguna mengisi form dan menekan tombol "Simpan",
data yang dimasukkan akan ditampilkan di dalam kartu yang terpisah untuk setiap data. Semua data ini disimpan dalam variabel
menggunakan rememberSaveable agar tetap terjaga meskipun aplikasi berhenti sementara atau layar diputar.
*/