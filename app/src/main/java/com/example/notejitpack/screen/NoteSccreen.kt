package com.example.notejitpack.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notejitpack.R
import com.example.notejitpack.components.NodeButton
import com.example.notejitpack.components.NoteInputText
import com.example.notejitpack.components.NoteRow
import com.example.notejitpack.data.Note

/**
 * Created by kannanpvm007 on 04-07-2023.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes:List<Note>,
    onAddNotes:(Note)-> Unit,
    onRemoveNotes:(Note)-> Unit,
    deleteAll:()-> Unit,
    update:(Note)-> Unit
) {

    var title by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }
    var button by remember { mutableStateOf("Save") }
    val context =  LocalContext.current

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = "notification icon",
                modifier = Modifier.clickable {
                    deleteAll.invoke()
                }

            )

        }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray)
        )

        /*content*/
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            NoteInputText(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = title,
                label = "Title",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()

                        })
                        title = it
                })

            NoteInputText(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = details,
                label = "Details",
                onTextChange = {

                    if (it.all { c ->
                            c.isWhitespace() || c.isLetter()
                        }) details = it
                })

            NodeButton(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = button,
                onclick = {
                    if (title.isNotEmpty() && details.isNotEmpty()) {
                        if (button == "Save") {
                            onAddNotes.invoke(Note(title = title, description = details))
                        } else {
                            update.invoke(Note(title = title, description = details))
                        }

                        Toast.makeText(context, "Note added", Toast.LENGTH_SHORT).show()
                        title=""
                        details=""
                        button="Save"
                    }


                })
        }
        Divider(modifier = Modifier.height(10.dp))
        LazyColumn(){
            items(notes){ note->
                NoteRow(note = note, onNoteClicked ={
                        selectedNote->
                    title= selectedNote.title
                    details= selectedNote.description
                    button="Update"
                },onNoteDeleteClicked={
                    onRemoveNotes(it)
                } )
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    NoteScreen(notes = emptyList(),{},{},{},{})
}