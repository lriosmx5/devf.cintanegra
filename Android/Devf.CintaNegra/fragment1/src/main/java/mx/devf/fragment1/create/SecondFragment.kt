package mx.devf.fragment1.create

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.devf.fragment1.R

/**
 * Created by Luis Rios on 02/10/17.
 */
class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_second, container, false)
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

}