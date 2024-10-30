package com.example.userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScreen(modifier: Modifier = Modifier){
    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("Laki-laki", "Perempuan")

    var namaUser by rememberSaveable { mutableStateOf("") }
    var emailUser by remember { mutableStateOf("") }
    var alamatUser by remember { mutableStateOf("") }
    var noHPUser by remember { mutableStateOf("") }
    var selectedGenderUser by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan nama anda")},
            label = { Text("Nama")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Row () {
            jenisKelamin.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = selectedGender == item,
                        onClick = {
                            selectedGender = item
                        })
                    Text(item)
                }
            }
        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan email anda")},
            label = { Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan alamat anda")},
            label = { Text("Alamat")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Masukkan no HP anda")},
            label = { Text("No HP")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Button(onClick = {
            namaUser = nama
            selectedGenderUser = selectedGender
            emailUser = email
            alamatUser = alamat
            noHPUser = noHP
        },  ) {
            Text("Submit")
        }

        Card(modifier.size(height = 140.dp, width = 300.dp)) {
            CardSection(judulParam = "Nama", isiParam = namaUser)
            CardSection(judulParam = "Email", isiParam = emailUser)
            CardSection(judulParam = "Alamat", isiParam = alamatUser)
            CardSection(judulParam = "No HP", isiParam = noHPUser)
            CardSection(judulParam = "Jenis Kelamin", isiParam = selectedGenderUser)
        }
    }

}

@Composable
fun CardSection (judulParam: String, isiParam: String) {
    Column (horizontalAlignment = Alignment.Start){

        Row (modifier = Modifier.fillMaxWidth().padding(2.dp),
            horizontalArrangement = Arrangement.Start)
        {
            Text(text = judulParam, modifier = Modifier.weight(0.8f).padding(start = 10.dp))
            Text(text = ":", modifier = Modifier.weight(0.2f).padding(start = 10.dp))
            Text(text = "$isiParam", modifier = Modifier.weight(2f).padding(start = 10.dp))
        }
    }
}