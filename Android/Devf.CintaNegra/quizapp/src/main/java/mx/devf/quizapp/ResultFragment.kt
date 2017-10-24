package mx.devf.quizapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import mx.devf.quizapp.models.Question
import org.w3c.dom.Text

/**
 * Created by Luis Rios on 17/10/17.
 */
class ResultFragment : Fragment() {

    companion object {
        val ARG_QUESTIONS = "ARG_QUESTIONS12"
        val ARG_SUCCESS = "ARG_CONTEST"
        val ARG_USERNAME = "ARG_USERNAME"
        val ARG_RESPUESTA = "ARG_RESPUESTA "

        fun newInstance(success : Int, questons : Int, userName : String = "", respuestas : String = "") : ResultFragment{

            val fragment =  ResultFragment()
            val extras = Bundle()
            extras.putInt(ARG_QUESTIONS, questons)
            extras.putInt(ARG_SUCCESS, success)
            extras.putString(ARG_USERNAME, userName)
            extras.putString(ARG_RESPUESTA, respuestas)
            fragment.arguments = extras
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val view =  inflater!!.inflate(R.layout.fragment_result, container, false)

        val txtView = view?.findViewById(R.id.txtView) as TextView
        txtView.text = "$success/$questions"

        if(username != "") {
            val tvTitle = view?.findViewById(R.id.tvTitle) as TextView
            tvTitle.text = "Tus resultados $username"
        }

        if(respuestas != ""){
            val tvRespuestasCorrectas = view?.findViewById(R.id.tvRespuestasCorrectas) as TextView
            tvRespuestasCorrectas.text = respuestas
        }else {
            view?.findViewById(R.id.scrollView).visibility = View.GONE
        }


        val progressBar = view?.findViewById(R.id.progressBar) as ProgressBar
        progressBar.max = questions
        progressBar.progress = success
        return view
    }

    var questions:Int = 5
    var success:Int = 0
    var username:String = ""
    var respuestas : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        success = arguments.getInt(ARG_SUCCESS)
        questions = arguments.getInt(ARG_QUESTIONS)
        username = arguments.getString(ARG_USERNAME)
        respuestas = arguments.getString(ARG_RESPUESTA)
    }



}