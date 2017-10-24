package mx.devf.quizapp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import mx.devf.quizapp.intefaces.onIteractiveNavigation
import mx.devf.quizapp.models.Question

/**
 * Created by Luis Rios on 11/10/17.
 */
class QuestionFragment : Fragment(), View.OnClickListener
{

    companion object {
        val ARG_TITLE = "GHDK564"

        fun newInstance(title : String) : QuestionFragment{

            val fragment =  QuestionFragment()
            val extras = Bundle()
            extras.putString(ARG_TITLE, title)
            fragment.arguments = extras
            return fragment
        }
    }

    private var title : String? = null
    public var Respuesta : Boolean? = null
    private var btnTrue : Button? = null
    private var btnFalse : Button? = null
    private var navigator : onIteractiveNavigation? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val view =  inflater!!.inflate(R.layout.fragment_question, container, false)

        val txtView = view?.findViewById(R.id.txtView) as TextView
        txtView.text = title

        btnTrue = view.findViewById(R.id.btnTrue) as Button
        btnFalse = view.findViewById(R.id.btnFalse) as Button
        btnTrue?.setOnClickListener(this)
        btnFalse?.setOnClickListener(this)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments.getString(ARG_TITLE)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        navigator = context as onIteractiveNavigation
    }

    override fun onClick(v: View?) {
        when (v?.id)
        {
            R.id.btnTrue -> {
                Respuesta = true
                btnTrue?.setBackgroundResource(R.color.colorAccent)
                btnFalse?.setBackgroundResource(android.R.drawable.btn_default);
                //navigator?.next()
            }
            R.id.btnFalse -> {
                Respuesta = false
                btnFalse?.setBackgroundResource(R.color.colorAccent)
                btnTrue?.setBackgroundResource(android.R.drawable.btn_default);
                //navigator?.next()
            }
        }
    }

   /* fun getRespuesta(): Boolean? {
        return r
    }*/

}