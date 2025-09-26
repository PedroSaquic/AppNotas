# \# AppDeNotas-MVVM

# 

# 

# \## Descripción

# Aplicación simple de notas utilizando Jetpack Compose y arquitectura MVVM.

# 

# 

# \### Cómo funciona MVVM en este proyecto

# \- \*\*Modelo (Note):\*\* `model/Note.kt` contiene la data class `Note`.

# \- \*\*ViewModel (NoteViewModel):\*\* mantiene la lista de notas en un `StateFlow<List<Note>>` y expone funciones `addNote` y `removeNote`.

# \- \*\*Vista (UI / Compose):\*\* `MainScreen` y componentes muestran la lista y llaman a las funciones del `ViewModel`.

# 

# 

# El `ViewModel` mantiene el estado a través de rotaciones de pantalla, por lo que la UI se recompone al recibir el nuevo estado.

# 

# 

# \### Capturas

# Incluye en este README dos capturas: una al agregar una nota y otra al eliminarla.

# 

# Agregar nota(./img/Agregar.png)

# Eliminar nota(./img/Eliminar.png)

