package mx.devf.fragment1

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

/**
 * Created by Luis Rios on 02/10/17.
 */
class InteractionFrag : Fragment(){

    var txtDefault : TextView? = null;
    var Texto : String = "";
    var interactive : onFragmentInteractionListener? = null;
    //staticos
    companion object {

        val Constante = "ARG_TXT";
        val ARG_TXT = "ARG_TXT";

        fun newIntances (text : String) :InteractionFrag
        {

            //uso de constante statica
            //InteractionFrag.Constante

            //creo la intancia
            val fragment = InteractionFrag()
            //crep un bundle que guardara los datos pasados como argumentos en mi fragmento
            val args = Bundle()
            args.putString(ARG_TXT, text)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater!!.inflate(R.layout.fragment_interaction, container, false)
        Toast.makeText(activity, Texto, Toast.LENGTH_LONG).show()
        txtDefault =  view.findViewById(R.id.txtDefault) as TextView
        txtDefault?.setText(Texto)

        val btn = view.findViewById(R.id.btn1) as Button

        btn.setOnClickListener(View.OnClickListener {
            interactive?.onInteraction("Hola desde el fragmento")
        })

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Texto = arguments.getString(ARG_TXT)
        //txtDefault =
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is onFragmentInteractionListener)
        {
            interactive = context
        }
    }

    public fun CambiarTexto(texto : String){
        txtDefault?.setText(texto)
    }


}