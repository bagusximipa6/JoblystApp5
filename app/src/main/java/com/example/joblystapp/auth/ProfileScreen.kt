package com.example.joblystapp.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.joblystapp.R

@Composable
fun ProfileScreen(
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.logo_avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
            )
        }

        item {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
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
                        navController.navigate("profile2")
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
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            Box {
                Text(
                    text = "One place you define yourself in your own words." +
                            "Whether you use it to put career choices in context, highlight your biggest achievements, " +
                            "or show off your personality, chance to put your best self out there. " +
                            "It strengthens your first impression in a way no other Profile section can.",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(
                    text = "Education",
                    modifier = Modifier
                        .clickable { }
                        .padding(end = 4.dp)
                        .weight(1f),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )

                Text(
                    text = "See All",
                    modifier = Modifier
                        .clickable { }
                        .padding(end = 4.dp)
                )
            }
        }

        items(3) {
            Image(
                painter = painterResource(id = R.drawable.logo_upn),
                contentDescription = null,
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(
                    text = "Skills",
                    modifier = Modifier
                        .clickable { }
                        .padding(end = 4.dp)
                        .weight(1f),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )

                Text(
                    text = "See All",
                    modifier = Modifier
                        .clickable { }
                        .padding(end = 4.dp)
                )
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Python",
                        modifier = Modifier.padding(4.dp)
                    )
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Cloud Computing",
                        modifier = Modifier.padding(4.dp)
                    )
                }

            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Javascript",
                        modifier = Modifier.padding(4.dp)
                    )
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Project Manager",
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileScreen(
        navController = rememberNavController()
    )
}