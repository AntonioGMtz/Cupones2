package com.example.cupones2.common.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import com.example.cupones2.R

/*
Reglas del negocio de la app
Validar el codigo
Procesar errores
Ocultar teclado
Validaciones o reglase especiales para adaptar en el codigo
 */
/* Las UTILS son clases AUXILIARES, que nos ayudan en tareas o reglas del negocio -
* conformar CAPA DE DOMINIO Y QUE PUEDAN SER UTILIZADAS EN DIFERENTES MODULOS */
fun validateTextCode(code:String):Boolean{
    return !(code.length < 5 || code.length > 10)
}

/* codigo de error establecido*/

fun getMsgErrorByCode(errorCode : String?) : Int = when(errorCode){
    Constans.ERROR_EXIST -> R.string.error_unique_code
    Constans.ERROR_LENGTH -> R.string.error_invalid_length
    else -> R.string.error_unknow
}


/*  oculta el teclado en pantalla (o teclado virtual) cuando se llama. */
fun hideKeyword(context: Context, view: View){

    
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken,0)
}