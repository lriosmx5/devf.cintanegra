package mx.devf.practicafragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity(), onInteractionFragment {

    override fun onClickReturn(tag: String) {
        val frag1 = supportFragmentManager.findFragmentByTag("frag1") as UnFragment
        val frag2 = supportFragmentManager.findFragmentByTag("frag2") as UnFragment
        when(tag){
            "frag1" ->{
                var count =frag2.ObttenerNumero() + 1
                frag2.CambiarTexto(count.toString())
            }
            "frag2" -> {
                var count =frag1.ObttenerNumero() + 1
                frag1.CambiarTexto(count.toString())
            }
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frag1 = UnFragment.newIntances("frag1", R.color.colorAccent)
        val frag2 = UnFragment.newIntances("frag2", R.color.colorAmarillo)

        supportFragmentManager.beginTransaction()
                .replace(R.id.content1, frag1, "frag1")
                .commit()

        supportFragmentManager.beginTransaction()
                .replace(R.id.content2, frag2, "frag2")
                .commit()
    }

}
