package mx.devf.practicafragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

/**
 * Created by Luis Rios on 03/10/17.
 */
class UnFragment() : Fragment(), View.OnClickListener{


    var txtDefault : TextView? = null;
    var MyColor : Int? = null;
    var Texto : String? = null;
    var interactive : onInteractionFragment? = null;

    constructor(parcel: Parcel) : this() {
        MyColor = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    companion object {
        val ARG_TXT = "ARG_TXT";
        val ARG_COLOR = "ARG_COLOR";

        fun newIntances (text : String, color : Int) : UnFragment
        {

            //uso de constante statica
            //InteractionFrag.Constante

            //creo la intancia
            val fragment = UnFragment()
            //crep un bundle que guardara los datos pasados como argumentos en mi fragmento
            val args = Bundle()
            args.putString(ARG_TXT, text)
            args.putInt(ARG_COLOR, color)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater!!.inflate(R.layout.fragment_uno, container, false)

        txtDefault =  view.findViewById(R.id.txtDefault) as TextView
        //txtDefault?.setText(Texto)
        view.setOnClickListener(this)
        view.setBackgroundColor(R.color.colorAccent)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyColor = arguments.getInt(ARG_COLOR)
        Texto = arguments.getString(ARG_TXT)
        //txtDefault =
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is onInteractionFragment)
        {
            interactive = context
        }
    }

    public fun ObttenerNumero() : Int{
        return txtDefault!!.text.toString().toInt()
    }


    public fun CambiarTexto(texto : String){
        txtDefault?.setText(texto)
    }

    override fun onClick(v: View?) {
        interactive!!.onClickReturn(Texto!!)
    }

}