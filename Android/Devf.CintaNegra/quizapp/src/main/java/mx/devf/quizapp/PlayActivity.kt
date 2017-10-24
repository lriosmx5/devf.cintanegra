package mx.devf.quizapp

import android.app.Fragment
import android.content.Intent
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import mx.devf.quizapp.global.Constants
import mx.devf.quizapp.global.shuffle
import mx.devf.quizapp.intefaces.onIteractiveNavigation
import mx.devf.quizapp.models.Question
import android.view.ViewGroup


//import java.util.Collections.shuffle

/**
 * Created by Luis Rios on 11/10/17.
 */
class PlayActivity : AppCompatActivity(), View.OnClickListener, onIteractiveNavigation {

    ///https://www.planetacurioso.com/2015/09/24/cierto-o-falso-pon-a-prueba-tus-conocimientos-con-este-cuestionario-respuestas/
    companion object {
        /*
        val preguntas = Array<Question>(5, { it ->
            when (it) {
                0 -> Question("¿Sera la respuesta true?", true)
                1 -> Question("¿Sera la respuesta false?", false)
                2 -> Question("¿Adivina la respuesta?", false)
                3 -> Question("¿La respuesta es lo contrario a lo segundo?", true)
                else -> Question("¿Es lo que no es pero puede ser lo que sera?", true)
            }})*/
        val PREGUNTAS = listOf<Question>(
                Question("¿Es cierto que Francia tiene más zonas horarias que Estados Unidos o Rusia?", true),
                Question("Albert Einstein suspendió un examen de matemáticas. ¿Verdadero o falso?", false),
                Question("¿Es cierto que en Júpiter llueven diamantes?", true),
                Question("Si te tragas un chicle, ¿tu cuerpo tardará siete años en digerirlo?", false),
                Question("Si pudieras doblar una hoja de papel 45 veces, alcanzaría la Luna", true),
                Question("¿Crees que al final de esta historia terminen juntos Eddy y Ken?", true)
        )
    }

    var preguntas = Companion.PREGUNTAS.toMutableList()
    var userName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        eetupViews()
    }


    private fun eetupViews(){
        userName = intent.extras?.getString(Constants.INTENT_KEY_USERNAME)
        val tvUSername = findViewById(R.id.tvUserName) as TextView
        tvUSername?.text = "Bienvenido $userName"
        findViewById(R.id.btnLeft).setOnClickListener(this)
        findViewById(R.id.btnRight).setOnClickListener(this)

        //ordenado
        //preguntas =  PlayActivity.PREGUNTAS.toMutableList()
        //shuffle(preguntas)

        setQuestions(preguntas[0], false)

    }

    private fun setQuestions(pregunta : Question, backStack : Boolean = true) {
        if(backStack) {
            supportFragmentManager.beginTransaction()
                    .addToBackStack("ASD")
                    .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit)
                    .replace(R.id.frameLayout, QuestionFragment.newInstance(pregunta.pregunta), pregunta.hashCode().toString())
                    .commit()
        }
        else
        {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, QuestionFragment.newInstance(pregunta.pregunta), pregunta.hashCode().toString())
                    .commit()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.btnLeft -> back()
            R.id.btnRight -> next()
        }
    }

    fun sendResults(success:Int, questions :Int )
    {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(Constants.INTENT_KEY_SUCCESS_QUESTIONS, success)
        intent.putExtra(Constants.INTENT_KEY_NUMBER_QUESTIONS, questions)
        startActivity(intent)
        finish()
    }

    fun printResults(success:Int, questions :Int)
    {
        var sb = StringBuilder()
        var pregErroneas = preguntas.filter { it.respuesta != it.respuestaUsuario }.toList()
        for(r in pregErroneas)
        {
            sb.appendln("- ${r.pregunta} la respuesta es ${r.respuesta}")
        }

        val fragment = ResultFragment.newInstance(success, questions, userName ?: "", sb.toString())

        clearBackStack()

        //val frameLayout = findViewById(R.id.frameResultLayout) as FrameLayout
        val frameLayout = findViewById(R.id.frameLayout) as FrameLayout
        frameLayout.visibility = View.VISIBLE

        findViewById(R.id.btnTrue).visibility= View.GONE
        findViewById(R.id.btnFalse).visibility= View.GONE
        findViewById(R.id.tvUserName).visibility= View.GONE
        // */

        frameLayout.getLayoutParams().height= ViewGroup.LayoutParams.MATCH_PARENT
        frameLayout.getLayoutParams().width= ViewGroup.LayoutParams.MATCH_PARENT



        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit)
                .replace(R.id.frameLayout, fragment)
                //.replace(R.id.frameLayout, fragment)
                .commit()

        //fragment.printResult(preguntas)
    }

    // CLEAR BACK STACK.
    private fun clearBackStack() {
        val fragmentManager = supportFragmentManager
        while (fragmentManager.backStackEntryCount !== 0) {
            fragmentManager.popBackStackImmediate()
        }

    }

    override fun next() {
        val count = supportFragmentManager.getBackStackEntryCount();
        if(count<preguntas.size)
        {
            setQuestions(preguntas[count])
        }
        else
        {
            var rCorrectas = 0
            for(index in 0..count-1) {
                val pregunta = preguntas[index]
                val fragment = supportFragmentManager.findFragmentByTag(pregunta.hashCode().toString()) as QuestionFragment
                pregunta.respuestaUsuario = fragment.Respuesta
                if(pregunta.respuesta == pregunta.respuestaUsuario)
                    rCorrectas++
            }
            //Toast.makeText(this, "Respuestas correctas $rCorrectas de $count", Toast.LENGTH_SHORT).show()
            //sendResults(rCorrectas, count)
            printResults(rCorrectas, count)
        }
    }

    override fun back() {
        val count = supportFragmentManager.getBackStackEntryCount();
        if(count>1)
            supportFragmentManager.popBackStack()
    }


}