package mx.devf.intents1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        //aqui me llegaron loa parametros
        val mensaje = intent.extras.get("key1");
        val numero = intent.extras.get("key2");
        Log.d("myLog", "Message: $mensaje")
        Log.d("myLog", "Numero: $numero")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //Toast.makeText(this, "No me toques...", Toast.LENGTH_SHORT);

    }
}
