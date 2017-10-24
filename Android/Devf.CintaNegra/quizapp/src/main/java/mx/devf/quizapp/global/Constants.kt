package mx.devf.quizapp.global

import java.util.*

/**
 * Created by Luis Rios on 16/10/17.
 */
class Constants {
    companion object Intents {
        val INTENT_KEY_USERNAME = "INTENT_KEY_USERNAME"
        val INTENT_KEY_SUCCESS_QUESTIONS = "INTENT_KEY_SUCCESS_QUESTIONS"
        val INTENT_KEY_NUMBER_QUESTIONS = "INTENT_KEY_NUMBER_QUESTIONS"
    }
}



fun <T:Comparable<T>>shuffle(items:MutableList<T>):List<T>{
    val rg : Random = Random()
    for (i in 0..items.size - 1) {
        val randomPosition = rg.nextInt(items.size)
        val tmp : T = items[i]
        items[i] = items[randomPosition]
        items[randomPosition] = tmp
    }
    return items
}

/* extension version */
fun <T> Iterable<T>.shuffle(): List<T> {
    val list = this.toMutableList().apply {  }
    Collections.shuffle(list)
    return list
}
