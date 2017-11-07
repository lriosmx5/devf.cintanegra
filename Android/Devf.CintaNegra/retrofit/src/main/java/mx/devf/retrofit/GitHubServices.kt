package mx.devf.retrofit

import okhttp3.ResponseBody
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Luis Rios on 26/10/17.
 */
interface GitHubServices {

    //@GET("users/KenMarquez")
    @GET("users/{username}")
    fun getUser(@Path("username") name : String) : Call<ResponseBody>

    @GET("users/{username}")
    fun getUserMagic(@Path("username") name : String) : Call<GitHubResponseUser>

    @GET("users/{username}/repos")
    fun getUserRepos(@Path("username") name : String) : Call<List<GitHubResponseRepo>>
}