package com.example.joblystapp.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.joblystapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TagScreen(navController: NavController) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
    ) {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = { navController.navigate("menu") }) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_back),
                            contentDescription = "Back",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Select Your Interest",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 36.dp)
                            .padding(2.dp),
                    )
                }
            }
        )
        // Search bar
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("What are you interested in?") },
            singleLine = true,
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.logo_search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(),
            keyboardActions = KeyboardActions(
                onDone = {
                }
            )
        )

        Text(
            text = "See All",
            modifier = Modifier
                .clickable {  }
                .padding(end = 8.dp)
                .align(Alignment.End)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(count = 8) { numb ->
                val imageResourceId = when (numb % 8) {
                    0 -> R.drawable.logo_designvisual
                    1 -> R.drawable.logo_dataanalyst
                    2 -> R.drawable.logo_uiux
                    3 -> R.drawable.logo_webdev
                    4 -> R.drawable.logo_architecture
                    5 -> R.drawable.logo_accountant
                    6 -> R.drawable.logo_civil
                    7 -> R.drawable.logo_projectmanager
                    else -> R.drawable.logo_dataanalyst
                }
                MyCard2(imageResourceId = imageResourceId)
            }
        }
    }
}

@Composable
fun MyCard2(imageResourceId: Int) {
    val painter = painterResource(id = imageResourceId)
    val imageModifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)

    Card(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable {

                }
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TagPreview() {
    TagScreen(
        navController = rememberNavController()
    )
}