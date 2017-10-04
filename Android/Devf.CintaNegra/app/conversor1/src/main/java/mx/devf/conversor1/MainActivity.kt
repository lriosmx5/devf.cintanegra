package mx.devf.conversor1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //var btnPesos : Button? = null;12
    //var btnDolares : Button? = null;
    val valorDolar : Double = 16.4;
    var txtPesos : EditText? = null;
    var txtDolares : EditText? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //btnPesos = findViewById(R.id.btnPesos) as Button;
        //btnDolares = findViewById(R.id.btnPesos) as Button;
        findViewById(R.id.btnPesos).setOnClickListener(this)
        findViewById(R.id.btnDolares).setOnClickListener(this)
        txtDolares = findViewById(R.id.txtDolares) as EditText
        txtPesos = findViewById(R.id.txtPesos) as EditText
    }


    override fun onClick(v: View?) {
        var valoractual : Double
        var resultado : Double
        try {
            when (v?.id) {
                R.id.btnDolares -> {
                    valoractual = txtDolares?.text.toString().toDouble()
                    resultado = valoractual * valorDolar;
                    txtPesos?.setText("%.2f".format(resultado))
                }

                R.id.btnPesos -> {
                    valoractual = txtPesos?.text.toString().toDouble()
                    resultado = valoractual / valorDolar;
                    txtDolares?.setText("%.2f".format(resultado))
                }
            }
        }catch (e: Exception) {
            Log.e("Error conversion", e.message)

        }
    }

}
