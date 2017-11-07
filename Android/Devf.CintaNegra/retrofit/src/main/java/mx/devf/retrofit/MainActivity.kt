package mx.devf.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), Callback<ResponseBody>{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUsers("kenMarquez")
    }

    fun getUsers(username : String) {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(GitHubServices::class.java)
        //service.getUser().execute() //hilo principal - android ya no te deja :(
        //service.getUser().enqueue(this)
        //service.getUser(username).enqueue(this)
        //service.getUserMagic(username).enqueue(Respuesta2Handler())
        service.getUserRepos(username).enqueue(Respuesta3Handler())
    }

    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
        Log.e("myLog", "Salio bien =)")
        Log.e("myLog", "Response codeo : {$response?.code()}")
        if(response?.code() == 200)
        {
            val jsons = response?.body()?.string()
            //Log.e("myLog", jsons)
            val json = JSONObject(jsons)
            //Log.e("myLog", json.toString(3))

            //Log.e("myLog", "Tu llave login es ${json.getString("login")}")
            //Log.e("myLog", "Tu id es ${json.getString("id")}")

            val gson = Gson()
            val parse = gson.fromJson(jsons, GitHubResponseUser::class.java)
            Log.e("myLog", "Tu llave login es ${parse.login}")
            Log.e("myLog", "Tu id es ${parse.id}")
        }
    }

    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
        Log.e("myLog", "Valio madres...")
        t?.printStackTrace()
    }

    class Respuesta2Handler : Callback<GitHubResponseUser>
    {
        override fun onResponse(call: Call<GitHubResponseUser>?, response: Response<GitHubResponseUser>?) {
            Log.e("myLog", "Response codeo : {$response?.code()}")

            val body = response?.body()
            Log.e("myLog", "Tu llave login es ${body?.login}")
            Log.e("myLog", "Tu id es ${body?.id}")
        }

        override fun onFailure(call: Call<GitHubResponseUser>?, t: Throwable?) {
            Log.e("myLog", "Valio madres...")
            t?.printStackTrace()
        }

    }

    class Respuesta3Handler : Callback<List<GitHubResponseRepo>>
    {
        override fun onResponse(call: Call<List<GitHubResponseRepo>>?, response: Response<List<GitHubResponseRepo>>?) {
            Log.e("myLog", "Response codeo : {$response?.code()}")

            val body = response?.body()
            for(repo in body!!)
            {
                Log.e("myLog", "--------------------------------")
                Log.e("myLog", "Tu id es ${repo.id}")
                Log.e("myLog", "Tu name es ${repo.name}")
                Log.e("myLog", "Tu fullname es ${repo.full_name}")
            }

        }

        override fun onFailure(call: Call<List<GitHubResponseRepo>>?, t: Throwable?) {
            Log.e("myLog", "Valio madres...")
            t?.printStackTrace()
        }

    }
}
