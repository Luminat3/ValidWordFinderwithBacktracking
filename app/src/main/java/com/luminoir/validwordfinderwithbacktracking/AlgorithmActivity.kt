package com.luminoir.validwordfinderwithbacktracking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminoir.validwordfinderwithbacktracking.ui.theme.ValidWordFinderwithBacktrackingTheme

@Composable
fun wordList(word: String, length: Int, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Text(
            text = word,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 4.dp))
        Text(text = length.toString())

    }
}


@Composable
fun inputRandomText(modifier: Modifier = Modifier)
{
    var text by remember { mutableStateOf(TextFieldValue(""))}
    androidx.compose.material3.OutlinedTextField(value = text ,
        label = { Text(text = "Enter your random alphabets") },
        onValueChange = { text = it },
        modifier = modifier.fillMaxWidth())
}

@Composable
fun ScrollToTop(onClick:()-> Unit, modifier: Modifier = Modifier)
{
    FilledIconButton(onClick = onClick, modifier = Modifier) {
        Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = "Scroll to top button")
    }
}

@Composable
fun AlgorithmApp()
{

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ValidWordFinderwithBacktrackingTheme {
        inputRandomText()
    }
}