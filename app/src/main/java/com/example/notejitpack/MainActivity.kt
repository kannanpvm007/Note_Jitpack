package com.example.notejitpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notejitpack.data.Note
import com.example.notejitpack.screen.NoteScreen
import com.example.notejitpack.screen.NoteViewModel
import com.example.notejitpack.ui.theme.NoteJitpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteJitpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel :NoteViewModel by  viewModels()
                    NoteApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun NoteApp(viewMode: NoteViewModel= viewModel()){
    val notes = viewMode.getAllNotes()
    NoteScreen(notes = notes, onAddNotes = {
        viewMode.addNote(it)

    },onRemoveNotes= {
        viewMode.removeNote(it)
    })
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteJitpackTheme {
        Greeting("Android")
    }
}