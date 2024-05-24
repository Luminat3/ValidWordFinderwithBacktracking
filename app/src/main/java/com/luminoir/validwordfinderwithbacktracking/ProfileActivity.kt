package com.luminoir.validwordfinderwithbacktracking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminoir.validwordfinderwithbacktracking.ui.theme.ValidWordFinderwithBacktrackingTheme

@Composable
fun Profile(modifier: Modifier = Modifier) {
    val montserrat = FontFamily(Font(R.font.montserrat_regular), Font(R.font.montserrat_bold, FontWeight.Bold))
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Adrian's Profile Picture",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(300.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
            )

            Text(
                text = "Adrian Chen",
                modifier = Modifier.padding(5.dp),
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
                Text(
                    text = "Universitas Multi Data Palembang",
                    fontSize = 17.sp,
                    fontFamily = montserrat
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(5.dp)) {
                Text(text = "Instagram : adrian_cai132", fontSize = 14.sp, fontFamily = montserrat)
            }
            Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(5.dp))
            {
                Text(text = "Github : Lumiant3", fontSize = 14.sp, fontFamily = montserrat)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Profile()
}