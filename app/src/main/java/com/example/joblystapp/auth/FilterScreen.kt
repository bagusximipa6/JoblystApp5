package com.example.joblystapp.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
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
fun FilterScreen(
    onBackPressed: () -> Unit
) {
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
                        text = "Filter",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 80.dp)
                            .padding(2.dp),
                    )
                }
            }
        )

        Text(
            text = "Job Level",
            modifier = Modifier
                .padding(4.dp)
                .padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Entry Level",
                        modifier = Modifier
                            .padding(4.dp)
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
                        text = "Mid-Senior Level",
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Associate",
                        modifier = Modifier
                            .padding(4.dp)
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
                        text = "Internship",
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
        }
        Text(
            text = "Working Hour",
            modifier = Modifier
                .padding(4.dp)
                .padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Full time",
                        modifier = Modifier
                            .padding(4.dp)
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
                        text = "Part Time",
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Contractual",
                        modifier = Modifier
                            .padding(4.dp)
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
                        text = "Freelance",
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
        }
        Text(
            text = "City",
            modifier = Modifier
                .padding(4.dp)
                .padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Bandung",
                        modifier = Modifier
                            .padding(4.dp)
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
                        text = "Yogyakarta",
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, Color.Blue)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Medan",
                        modifier = Modifier
                            .padding(4.dp)
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
                        text = "Bali",
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
        }
        Text(
            text = "Salary",
            modifier = Modifier
                .padding(4.dp)
                .padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column {
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
                        text = "Rp.200.000",
                        modifier = Modifier
                            .padding(4.dp)
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
                        text = "Rp.500.000",
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
            var sliderPosition by rememberSliderPosition()

            RangeSlider(
                value = sliderPosition,
                onValueChange = {
                    sliderPosition = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = SliderDefaults.colors(),
                steps = 100
            )
        }
    }
}

@Composable
fun rememberSliderPosition(): MutableState<ClosedFloatingPointRange<Float>> {
    return remember { mutableStateOf(0.2f..0.8f) }
}

@Composable
fun MyCard(imageResourceId: Int) {
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
fun FilterPreview() {
    FilterScreen(onBackPressed = {})
}