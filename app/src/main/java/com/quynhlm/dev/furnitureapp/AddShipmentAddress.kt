package com.quynhlm.dev.furnitureapp

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController

class AddShipmentAddress : ComponentActivity() {
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddShipmentScreen(navController : NavController){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Add shipping address",
                            textAlign = TextAlign.Center,
                            fontSize = 17.sp,
                            modifier = Modifier.fillMaxWidth(),
                            fontFamily = FontFamily(
                                Font(R.font.merriweather_regular)
                            )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp()}) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrowback),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            modifier = Modifier.size(24.dp),
                            onClick = { /* Handle action */ }) {
                            // Action icon (e.g., settings or more options) can be added here
                        }
                    },
                )
            },
            content = { innerPadding ->
                AddShipment(innerPadding)
            }
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddShipment(innerPaddingValues: PaddingValues){

        val context = LocalContext.current

        var fullName by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var zipcode by remember { mutableStateOf("") }
        var selectedCountry by remember { mutableStateOf("") }
        var selectedCity by remember { mutableStateOf("") }
        var selectedDistrict by remember { mutableStateOf("") }

        var expanded by remember { mutableStateOf(false) }
        var selectedText by remember { mutableStateOf("") }
        val options = listOf("Option 1", "Option 2", "Option 3")

        Column (modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, innerPaddingValues.calculateTopPadding(), end = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween) {

            Column (modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
                verticalArrangement = Arrangement.SpaceAround){
                OutlinedTextField(
                    value = fullName,
                    label = { Text(text = "Full name") },
                    placeholder = { Text(text = "Ex: Bruno Pham") },
                    onValueChange = {fullName = it},
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color("#E0E0E0".toColorInt()),
                        unfocusedContainerColor = Color("#E0E0E0".toColorInt()),
                        disabledContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )


                OutlinedTextField(
                    value = address,
                    label = { Text(text = "Address") },
                    placeholder = { Text(text = "Ex: 25 Robert Latouche Street") },
                    onValueChange = {address = it},
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color("#E0E0E0".toColorInt()),
                        unfocusedContainerColor = Color("#E0E0E0".toColorInt()),
                        disabledContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )

                OutlinedTextField(
                    value = zipcode,
                    onValueChange = { zipcode = it },
                    label = { Text(text = "Zipcode (Postal Code)") },
                    placeholder = { Text(text = "Ex: 123456") },
                    modifier = Modifier.fillMaxWidth(),
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = it
                        }
                    ) {
                        OutlinedTextField(
                            value = selectedCountry,
                            onValueChange = {selectedCountry = it},
                            label = { Text(text = "Country") },
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                                .clickable { expanded = true },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color("#E0E0E0".toColorInt()),
                                unfocusedContainerColor = Color("#E0E0E0".toColorInt()),
                                disabledContainerColor = Color.Gray,
                                unfocusedIndicatorColor = Color.Gray,
                            ),
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            options.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedCountry = item
                                        expanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        OutlinedTextField(
                            value = selectedCity,
                            onValueChange = {selectedCity = it},
                            label = { Text(text = "City") },
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            options.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedCountry = item
                                        expanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = it
                        }
                    ) {
                        OutlinedTextField(
                            value = selectedDistrict,
                            onValueChange = {selectedDistrict = it},
                            label = { Text(text = "District") },
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color("#E0E0E0".toColorInt()),
                                unfocusedContainerColor = Color("#E0E0E0".toColorInt()),
                                disabledContainerColor = Color.Gray,
                                unfocusedIndicatorColor = Color.Gray,
                            ),
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            options.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedDistrict = item
                                        expanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }
            }

           Column {
               CustomButton(
                   title = "SAVE ADDRESS",
                   modifier = Modifier
                       .fillMaxWidth()
                       .height(60.dp)
                       .clip(RoundedCornerShape(8.dp))
                       .background(Color(0xFF242424))
                       .clickable(onClick = {
//                           val newAddress = Addresses(
//                               fullName = fullName,
//                               addressLine = address,
//                               zipcode = zipcode,
//                               country = selectedCountry,
//                               city = selectedCity,
//                               district = selectedDistrict
//                           )
//                           GlobalScope.launch(Dispatchers.IO) {
//                               addressDao.insertAddress(newAddress)
//                               Toast.makeText(context, "Address saved", Toast.LENGTH_SHORT).show()
//                               navController.navigateUp()
//                           }
                       }),
                   textStyle = TextStyle(
                       fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)),
                       fontWeight = FontWeight(600),
                       fontSize = 18.sp,
                       color = Color.White
                   ),
               )
               Spacer(modifier = Modifier.height(15.dp))
           }
        }
    }