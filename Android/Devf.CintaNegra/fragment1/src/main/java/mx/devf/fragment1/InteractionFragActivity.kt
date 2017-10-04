package mx.devf.fragment1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import mx.devf.fragment1.R

class InteractionFragActivity : AppCompatActivity(), onFragmentInteractionListener {

    override fun onInteraction(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        //location de frag
        val frag1 = supportFragmentManager.findFragmentByTag("frag1")
        if(frag1 is InteractionFrag)
        {
            frag1.CambiarTexto(message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interaction_fragment)
        /*
        val fragment = InteractionFrag()
        //crep un bundle que guardara los datos pasados como argumentos en mi fragmento
        val args = Bundle()
        args.putString(InteractionFrag.ARG_TXT, "HOLA MUNDO")
        fragment.arguments = args
        */

        val fragment = InteractionFrag.newIntances("Hola Dev.F")

        changeFragment(fragment)

    }

    //Cambiamos el fagmento
    fun changeFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.content, fragment, "frag1")
                .commit()
    }

}
