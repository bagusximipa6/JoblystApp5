package com.example.joblystapp.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(onBackPressed: () -> Unit, navController: NavController) {
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
                    IconButton(onClick = { onBackPressed() }) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_back),
                            contentDescription = "Back",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Details",
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )
                }
            }
        )
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Spacer(modifier = Modifier.height(50.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            content = {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.logo_details),
                        contentDescription = null,
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        content = {
                            Button(
                                onClick = {
                                },
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(50.dp),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = contentColorFor(MaterialTheme.colorScheme.secondary)
                                ),
                                contentPadding = PaddingValues(8.dp)
                            ) {
                                Text(text = "Job Description")
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Button(
                                onClick = {
                                    navController.navigate("details2")
                                },
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(50.dp),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = contentColorFor(MaterialTheme.colorScheme.primary)
                                ),
                                contentPadding = PaddingValues(8.dp)
                            ) {
                                Text(text = "Company")
                            }
                        }
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Job Description",
                        modifier = Modifier
                            .clickable { }
                            .padding(end = 4.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = "We are currently looking for a web developer with 2 years experience, " +
                                "and can operate our product, namely web builder, " +
                                "we will recruit candidates on a full-time basis and can work from anywhere, aka WFA.",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "A must Have Skill",
                        modifier = Modifier
                            .clickable { }
                            .padding(end = 4.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = "Java script\n" +
                                "html, css\n" +
                                "Mastering web builder especially webflow\n" +
                                "php",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Candidate Recruitment",
                        modifier = Modifier
                            .clickable { }
                            .padding(end = 4.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = "Graduated from S1 majoring in informatics\n" +
                                "1 - 2 years of experience with web builder\n" +
                                "Mastering web builder especially webflow\n" +
                                "Strong communication, design and creative skills\n" +
                                "Maximum age of 35 years",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    DetailScreen(
        onBackPressed = {},
        navController = rememberNavController()
    )
}
