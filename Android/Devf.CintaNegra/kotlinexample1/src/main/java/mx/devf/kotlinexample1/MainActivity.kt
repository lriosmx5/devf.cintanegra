package mx.devf.kotlinexample1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onClick(v: View?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        /*
        if(v?.id == R.id.boton1)
        {
            Toast.makeText(this, "Dev.F te saluda", Toast.LENGTH_SHORT).show()
        }
        if(v?.id == R.id.textView1)
        {
            Toast.makeText(this, "Luis te saluda", Toast.LENGTH_SHORT).show()
        }// */
        when(v?.id)
        {
            R.id.boton1 -> Toast.makeText(this, "Dev.F te saluda", Toast.LENGTH_SHORT).show()
            R.id.textView1 -> Toast.makeText(this, "Luis te saluda", Toast.LENGTH_SHORT).show()
        }
        if(v?.id == R.id.textView1) {
            textView1?.text = editText1?.text
        }

    }

    private var editText1: EditText? = null;
    private var boton1 : Button? = null;
    private var textView1 : TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1) as EditText
        boton1 = findViewById(R.id.boton1) as Button
        textView1 = findViewById(R.id.textView1) as TextView

        textView1?.text =  "Hello Dev.F"

        textView1?.setOnClickListener(this)
        boton1?.setOnClickListener(this)
        /*boton1?.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Dev.F te saluda", Toast.LENGTH_SHORT).show()
        })// */


    }

    fun checkPalindrome(inputString: String): Boolean {
        var pos1 = 0;
        var pos2 = inputString.length - 1
        while(--pos1 < ++pos2)
            if (inputString[pos1] != inputString[pos1])
                return false
        return true
    }
}


