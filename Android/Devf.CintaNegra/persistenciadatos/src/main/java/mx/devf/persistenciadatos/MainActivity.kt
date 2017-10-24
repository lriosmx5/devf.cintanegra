package mx.devf.persistenciadatos

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val PREFERENCE_NAME = "Preferencio"
    val PREF_KEY_SALUDO = "saludo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, GetSaludo(), Toast.LENGTH_SHORT ).show()
        saveSaludo("Saludo Guardado!!")
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(this, GetSaludo(), Toast.LENGTH_SHORT ).show()
    }

    fun GetSaludo() : String
    {
        val preference = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val saludo = preference.getString(PREF_KEY_SALUDO, "Hola mondo grovee!")
        return saludo
    }

    fun saveSaludo(saludo : String){
        val preference = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(PREF_KEY_SALUDO, saludo)
        editor.commit()
    }

}
