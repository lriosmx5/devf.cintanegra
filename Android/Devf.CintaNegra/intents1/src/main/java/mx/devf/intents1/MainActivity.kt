package mx.devf.intents1

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var imageCamara : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.btn1).setOnClickListener(this)
        findViewById(R.id.btn_call).setOnClickListener(this)
        findViewById(R.id.btn_link).setOnClickListener(this)
        findViewById(R.id.btn_abrir_mapa).setOnClickListener(this)
        findViewById(R.id.btn_abrir_street_view).setOnClickListener(this)
        findViewById(R.id.btn_camara).setOnClickListener(this)
        findViewById(R.id.btn_galeria).setOnClickListener(this)
        imageCamara = findViewById(R.id.img_Camara) as ImageView

    }

    override fun onClick(v: View?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when(v?.id)
        {
            R.id.btn1 -> openActivity()
            R.id.btn_call -> doCall()
            R.id.btn_link -> openLink()
            R.id.btn_abrir_mapa -> abrirMapa()
            R.id.btn_abrir_street_view -> abrirStreetView()
            R.id.btn_camara -> takePicture()
            R.id.btn_galeria -> findPicture()
        }
    }


    fun takePicture()
    {
        val camaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(camaraIntent, 1032) //codigo que asigne a mi camara
    }

    fun findPicture()
    {
        val pickPhoto = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickPhoto, 1234)//one can be replaced with any action code
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //super.onActivityResult(requestCode, resultCode, data)
        //1032 - codigo que asigne para la camara
        when(requestCode)
        {
            1032 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val photo: Bitmap = data?.extras?.get("data") as Bitmap
                    imageCamara?.setImageBitmap(photo)
                } else if (resultCode == Activity.RESULT_CANCELED)
                    Toast.makeText(this, "Se cancelo la captura de camara, no se tomo la foto", Toast.LENGTH_SHORT)
            }
            1234 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val uriImage = data?.data as Uri
                    imageCamara?.setImageURI(uriImage)
                } else if (resultCode == Activity.RESULT_CANCELED)
                    Toast.makeText(this, "Se cancelo la captura de camara, no se tomo la foto", Toast.LENGTH_SHORT)
            }


        }
    }

    //TODO : intent para buscar la foto de la galeria

    fun abrirStreetView(){
        val gmmIntentUri = Uri.parse("“google.streetview:cbll=20.6488206,-103.4063073")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.`package` = "com.google.android.apps.maps"
        startActivity(mapIntent)
    }

    fun abrirMapa()
    {
        val direccion = "https://maps.googleapis.com/maps/api/directions/json?origin=19.4301524,-99.211045&destination=20.5307051,-97.457894&key=AIzaSyBAvGj8Asdi5OVQpxZAsk5TBOPzBB54WiQ"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = (Uri.parse(direccion))
        startActivity(intent)
    }

    fun openLink() {
        val url = "https://www.apple.com"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    fun openActivity(){
        val intent = Intent(this, ThirdActivity::class.java)
        //pasando parametros a la siguiente ventana
        intent.putExtra("key1", "Pasando datos")
        intent.putExtra("key2", 2017)
        startActivity(intent)
    }

    fun doCall()
    {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"4771413910"))
        startActivity(intent)
    }
}
