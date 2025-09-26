package vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import model.Note


class NoteViewModel: ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    fun addNote(text:String){
        if(text.isBlank()) return
        val new = Note(text = text.trim())
        _notes.value = _notes.value + new
    }
    fun removeNote(id: Long){
        _notes.value = _notes.value.filterNot{ it.id == id}
    }

    fun seedSample(){
        if(_notes.value.isEmpty()){
            _notes.value = listOf(
                Note(text = "Estuadiar MVVM"),
                Note(text = "Comprar leche"),
                Note(text = "Enviar correo al profe")
            )
        }
    }
}