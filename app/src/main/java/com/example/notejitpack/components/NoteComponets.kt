package com.example.notejitpack.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notejitpack.data.Note
import java.time.format.DateTimeFormatter

/**
 * Created by kannanpvm007 on 04-07-2023.
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
    modifier: Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImEAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChange,
        maxLines = maxLine,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImEAction()
            keyboardController?.hide()
        }),

        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent
        ), modifier = modifier.background(Color.Transparent)
    )

}

@Composable
fun NodeButton(
    modifier: Modifier,
    text: String,
    onclick: () -> Unit,
    enable: Boolean = true
) {
    Button(
        onClick = onclick, shape = CircleShape, enabled = enable, modifier = modifier
    ) {
        Text(text = text)

    }

}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {

    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 13.dp, bottomStart = 13.dp))
            .fillMaxWidth(), color = Color(0xFB5B679), shadowElevation = 2.dp
    ) {
        Column(
            modifier
                .clickable {onNoteClicked.invoke(note) }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = MaterialTheme.typography.titleMedium)
            Text(text = note.description, style = MaterialTheme.typography.titleSmall)
            Text(text = note.entryTime.format(DateTimeFormatter.ofPattern("EEE, d MMM")), style = MaterialTheme.typography.titleSmall)

        }

    }
}

@Preview
@Composable
fun View() {
    NoteInputText(modifier = Modifier, text = "fr", label = "fff", onTextChange = {})
}