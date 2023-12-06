package com.example.joblystapp.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.joblystapp.R

@Composable
fun ProfileScreen2(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_avatar),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = {
                    navController.navigate("profile1")
                },
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = contentColorFor(MaterialTheme.colorScheme.secondary)
                ),
                contentPadding = PaddingValues(16.dp)
            ) {
                Text(text = "About Me")
            }
            Button(
                onClick = {
                },
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = contentColorFor(MaterialTheme.colorScheme.primary)
                ),
                contentPadding = PaddingValues(16.dp)
            ) {
                Text(text = "Portofolio")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "See All",
            modifier = Modifier
                .clickable {  }
                .padding(end = 4.dp)
                .align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(count = 8) { numb ->
                val imageResourceId = when (numb % 8) {
                    0 -> R.drawable.portofolio1
                    1 -> R.drawable.portofolio2
                    2 -> R.drawable.portofolio3
                    3 -> R.drawable.portofolio4
                    4 -> R.drawable.portofolio1
                    5 -> R.drawable.portofolio2
                    6 -> R.drawable.portofolio3
                    7 -> R.drawable.portofolio4
                    else -> R.drawable.logo_dataanalyst
                }
                MyCard2(imageResourceId = imageResourceId)
            }
        }
    }
}