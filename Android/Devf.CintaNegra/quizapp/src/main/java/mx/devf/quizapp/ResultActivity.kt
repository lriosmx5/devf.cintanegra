package mx.devf.quizapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import mx.devf.quizapp.global.Constants
import mx.devf.quizapp.models.Question

/**
 * Created by Luis Rios on 17/10/17.
 */
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        eetupViews()
    }


    private fun eetupViews(){
        val questions = intent.extras?.getInt(Constants.INTENT_KEY_NUMBER_QUESTIONS)
        val success = intent.extras?.getInt(Constants.INTENT_KEY_SUCCESS_QUESTIONS)

        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ResultFragment.newInstance(success!!, questions!!))
                .commit()

    }

}