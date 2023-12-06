package com.example.joblystapp.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.joblystapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    onBackPressed: () -> Unit,
    navController: NavController
) {
    var searchText by remember { mutableStateOf("") }
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = { onBackPressed() }) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_back),
                        contentDescription = "Back",
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Message",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 70.dp)
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
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        items(1) {
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_chat),
                contentDescription = null,
                modifier = Modifier
                    .size(450.dp)
                    .offset(y = (-115).dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_chat2),
                contentDescription = null,
                modifier = Modifier
                    .size(450.dp)
                    .offset(y = (-115).dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatPreview() {
    ChatScreen(
        onBackPressed = {},
        navController = rememberNavController())
}