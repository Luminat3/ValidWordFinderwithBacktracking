package com.luminoir.validwordfinderwithbacktracking

import android.app.Application
import android.content.res.Resources.Theme
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminoir.validwordfinderwithbacktracking.ui.theme.ValidWordFinderwithBacktrackingTheme
import kotlinx.coroutines.launch

@Composable
fun WordList(kata: String, panjang: Int, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier
        .padding(3.dp)
        .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp))
        .height(50.dp)) {
        Text(text = kata, fontWeight = FontWeight.Bold, modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(start = 10.dp)
            )
        Text(text = panjang.toString(), fontWeight = FontWeight.Bold, modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(start = 10.dp)
            )
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Composable
fun AlgorithmApp(modifier: Modifier = Modifier, viewModel: AlgorithmViewModel = androidx.lifecycle.viewmodel.compose.viewModel())
{
    val montserrat = FontFamily(Font(R.font.montserrat_regular), Font(R.font.montserrat_bold, FontWeight.Bold))
    var input by remember { mutableStateOf(TextFieldValue("")) }
    Box(modifier = modifier
        .background(color = Color.White)
        .fillMaxSize()
        .windowInsetsPadding(WindowInsets.systemBars)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            OutlinedTextField(value = input,
                label = { Text(text = "Masukkan Alfabet Random", fontFamily = montserrat ,fontWeight = FontWeight.Bold) },
                onValueChange = {
                    input = it
                    viewModel.alfabet= it.text.trim()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp))

            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Search,"") },
                text = { Text("Cari Kata Valid", fontFamily = montserrat, fontWeight = FontWeight.Bold) },
                onClick = { viewModel.cariKata() },
                elevation = FloatingActionButtonDefaults.elevation(8.dp),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Kata yang Valid / Dapat Dibentuk :",
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold, modifier = Modifier
                    .padding(10.dp)
                    .padding(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
                Text(text = "Kata-Kata", fontWeight = FontWeight.Bold, modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 10.dp))
                Text(text = "Panjang Kata", fontWeight = FontWeight.Bold, modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 10.dp))
            }
//            Column(modifier = Modifier
//                .padding(top = 6.dp)
//                .verticalScroll(rememberScrollState())) {
//                viewModel.hasil.forEach { (kata, panjangKata) ->
//                    WordList(kata = kata, panjang = panjangKata)
//                }
//            }

            LazyColumn(modifier = Modifier
                .padding(top = 6.dp)) {
                items(viewModel.hasil){ (kata, panjangKata) ->
                    WordList(kata = kata, panjang = panjangKata)
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun AppPreview() {
    ValidWordFinderwithBacktrackingTheme {
        AlgorithmApp()
    }
}