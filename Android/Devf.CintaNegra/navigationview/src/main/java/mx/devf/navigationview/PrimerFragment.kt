package mx.devf.navigationview

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Luis Rios on 10/10/17.
 */
class PrimerFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_primero, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

}
