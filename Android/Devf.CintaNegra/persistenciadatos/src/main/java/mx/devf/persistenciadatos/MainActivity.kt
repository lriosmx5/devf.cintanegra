package mx.devf.persistenciadatos

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    val PREFERENCE_NAME = "Preferencio"
    val PREF_KEY_SALUDO = "saludo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        //Toast.makeText(this, GetSaludo(), Toast.LENGTH_SHORT ).show()
        //saveSaludo("Saludo Guardado!!")

        val user = UserApp()

        user.id = 1
        user.age = 22
        user.name = "Luis"
        user.lastname = "Rios"
        user.direccion = "jdkfsdl"
        saveUser(user)

        val user2 = UserApp()

        user2.id = 2
        user2.age = 43
        user2.name = "Manriquez"
        user2.lastname = "Godoi"
        user2.direccion = "UOAOAOA"
        saveUser(user2)

        //getUsers()

        getUser(2)
        getUser(1)
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(this, GetSaludo(), Toast.LENGTH_SHORT ).show()
    }

    fun GetSaludo(): String {
        val preference = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val saludo = preference.getString(PREF_KEY_SALUDO, "Hola mondo grovee!")
        return saludo
    }

    fun saveSaludo(saludo: String) {
        val preference = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(PREF_KEY_SALUDO, saludo)
        editor.commit()
    }

    fun saveUser(user: UserApp) {
        val realm = Realm.getDefaultInstance()

        realm.beginTransaction()

        try {
            //Error la segunda ocasion por la llave primaria duplicada
            //realm.copyFromRealm(user)

            realm.copyToRealmOrUpdate(user)
            realm.commitTransaction()
        } catch (ex: Exception) {
            Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun getUsers() {
        val realm = Realm.getDefaultInstance()
        val usuarios = realm.where(UserApp::class.java).findAll()
        //Toast.makeText(this, "Tienes ${usuarios.size} usuarios", Toast.LENGTH_SHORT).show()
        for (usuario in usuarios) {
            Log.e("MyLog", usuario.toString())
        }
    }

    fun getUser(id : Int) {
        val realm = Realm.getDefaultInstance()
        val user = realm.where(UserApp::class.java)
                .equalTo("id", id)
                .findFirst()
        if(user != null)
        {
            Log.e("Mylog", "find $id - ${user.toString()}")
        }
    }
}