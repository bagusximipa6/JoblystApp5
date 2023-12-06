package com.example.joblystapp.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.joblystapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onBackPressed: () -> Unit, navController: NavController) {
    var searchText by remember { mutableStateOf("") }

    var selectedTabIndex by remember { mutableIntStateOf(0) }

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
                    Text("Welcome back!")
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { onBackPressed() }) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_profile),
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(55.dp)
                                .padding(end = 16.dp)
                        )
                    }
                }
            }
        )
        Row {
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                label = { Text("What job are you looking for?") },
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
            Button(
                onClick = {
                    navController.navigate("tag")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = contentColorFor(MaterialTheme.colorScheme.primary)
                ),
                contentPadding = PaddingValues(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_filter),
                    contentDescription = null,
                    modifier = Modifier
                        .size(450.dp)
                )
            }
        }

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(count = 4) { numb ->
                val imageResourceId = when (numb % 4) {
                    0 -> R.drawable.logo_company
                    1 -> R.drawable.logo_company
                    2 -> R.drawable.logo_company
                    3 -> R.drawable.logo_company
                    else -> R.drawable.logo_company
                }
                MyColumn(imageResourceId = imageResourceId, navController)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(icon = Icons.Default.Home, selected = selectedTabIndex == 0) {
                selectedTabIndex = 0
                navController.navigate("menu")
            }
            BottomNavItem(icon = Icons.Default.Send, selected = selectedTabIndex == 1) {
                selectedTabIndex = 1
            }
            BottomNavItem(icon = Icons.Default.Notifications, selected = selectedTabIndex == 2) {
                selectedTabIndex = 2
                navController.navigate("notif")
            }
            BottomNavItem(icon = Icons.Default.Favorite, selected = selectedTabIndex == 3) {
                selectedTabIndex = 3
                navController.navigate("saved")
            }
            BottomNavItem(icon = Icons.Default.Person, selected = selectedTabIndex == 4) {
                selectedTabIndex = 4
                navController.navigate("profile1")
            }
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {
    val tint = if (selected) {
        MaterialTheme.colorScheme.primary
    } else {
        contentColorFor(MaterialTheme.colorScheme.background)
    }

    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick)
            .background(if (selected) MaterialTheme.colorScheme.background else Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun MyColumn(imageResourceId: Int, navController: NavController) {
    val painter = painterResource(id = imageResourceId)
    val imageModifier = Modifier
        .width(80.dp)
        .height(80.dp)
        .clip(shape = RoundedCornerShape(8.dp))

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    navController.navigate("details1")
                }
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Job Position",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Company Name",
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Work Hour")
                    Text(text = "Work Region")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(
        onBackPressed = {},
        navController = rememberNavController()
    )
}