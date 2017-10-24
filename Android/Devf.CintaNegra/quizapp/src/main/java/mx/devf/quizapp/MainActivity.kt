package mx.devf.quizapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.EditText
import android.widget.Toast
import mx.devf.quizapp.global.Constants

class MainActivity : AppCompatActivity(), View.OnClickListener {
//, View.OnClickListener {

    var inputUserName : EditText? = null
    var fab : FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputUserName = findViewById(R.id.userName) as EditText
        fab = findViewById(R.id.fabButton) as FloatingActionButton

    }

    override fun onStart() {
        super.onStart()
        fab?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        when(p0?.id)
        {
            R.id.fabButton ->{
                val userName = inputUserName?.text.toString()
                if(userName.isEmpty()) {
                    Toast.makeText(this, R.string.username_null, Toast.LENGTH_LONG).show()
                }
                else
                {
                    sendPlay(userName)
                    //Transition
                }
            }
        }
    }

    fun sendPlay(username : String)
    {
        val intent = Intent(this, PlayActivity::class.java)
        intent.putExtra(Constants.INTENT_KEY_USERNAME, username)
        startActivity(intent)
        finish()
    }
}
