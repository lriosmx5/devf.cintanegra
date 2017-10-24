package mx.devf.quizapp.models

/**
 * Created by Luis Rios on 16/10/17.
 */
data class Question (val pregunta : String, val respuesta : Boolean, var respuestaUsuario : Boolean? = null )