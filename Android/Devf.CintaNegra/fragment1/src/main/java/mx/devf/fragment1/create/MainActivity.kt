package mx.devf.fragment1.create

//import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import mx.devf.fragment1.R

class MainActivity : AppCompatActivity() {

    //var layoutFrame: FrameLayout? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //layoutFrame = findViewById(R.id.contentPanel) as FrameLayout

        val orientation = resources.configuration.orientation;

        when (orientation) {
            0, 1 ->{
                //layoutFrame?.visibility = View.GONE
                findViewById(R.id.content).visibility = View.GONE
            }
            2 -> {
                val frag3 = ThirdFragment()
                val fragmentManager = supportFragmentManager

                fragmentManager.beginTransaction()
                        .replace(R.id.content, frag3)
                        .commit()
            }
        }
    }



}
