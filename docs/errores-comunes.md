Errores Encontrados



error#1: al declarar emptyList<>()

captura del error(./img/error1.PNG)

causa: signos adicionales "<>"

solución: eliminar signos adicionales "<> / limpiar imports inecesarios que podrían causar conflicto - import kotlin.coroutines.coroutineContext



error#2: al generar MaterialTheme

captura el error(./img/error2.PNG)

causa: falta composable

solución: crear un @composable dentro el mainactivity

