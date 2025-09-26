package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import model.Note
import vm.NoteViewModel

@Composable
fun MainScreen(vm: NoteViewModel){
    val notes by vm.notes.collectAsStateWithLifecycle()

    var input by remember { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Text(
            text = "Notas (Compose + MVVM)",
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = input,
            onValueChange = { input = it},
            label = { Text("Escribe una nota")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
            Spacer(Modifier.weight(1f))
            Button(
                onClick = {
                    vm.addNote(input)
                    input = ""
                }
            ){
                Text("Agregar")
            }
        }

        Divider()

        if (notes.isEmpty()){
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text("Sin notas. Agrega tu primer nota aqui")
            }
        }else{
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(notes, key = { it.id}) { note ->
                    NoteItem(
                        note = note,
                        oneDelete = { vm.removeNote(note.id)}
                    )
                }
            }
        }
    }

}

@Composable
fun NoteItem(
    note: Note,
    oneDelete: () -> Unit
){
    Surface(
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 1.dp,
        shadowElevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = note.text,
                modifier = Modifier.weight(1f),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.width(12.dp))
            OutlinedButton(onClick = { oneDelete()}){
                Text("Eliminar")
            }
        }
    }
}

