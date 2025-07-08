package com.app.latihan_jetpack.screen

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.latihan_jetpack.components.NoteCard
import com.app.latihan_jetpack.model.viewmodel.NoteViewModel
import com.app.latihan_jetpack.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: NoteViewModel = viewModel()
){
    val notesState by viewModel.notes.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 26.dp)
    ){
        if (notesState.isEmpty()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else{
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ){
                items(notesState){
                    note ->
                    NoteCard(note)
                }
            }
        }
    }
}

//fun HomeScreen(navController: NavController) {
//    // State untuk menyimpan teks yang diketik user
//    var text by remember { mutableStateOf("") }
//
//    // Box untuk mengatur konten ke tengah layar
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        // Kolom berisi label, input teks, dan tombol
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text("Masukkan Nama:") // Label input
//            TextField(
//                value = text, // Nilai teks dari state
//                onValueChange = { text = it }, // Perubahan input disimpan ke state
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(16.dp)) // Jarak antar komponen
//            Button(onClick = {
//                // Navigasi ke halaman Result dengan teks sebagai argumen
//                navController.navigate(route = Screen.Result.passText(text))
//            }) {
//                Text("Submit") // Teks tombol
//            }
//        }
//    }
//}

// Preview untuk menampilkan tampilan HomeScreen di Android Studio
@Composable
@Preview(showBackground = true)
fun HomeScreenView() {
    HomeScreen(
        navController = rememberNavController() // Dummy navController untuk preview
    )
}