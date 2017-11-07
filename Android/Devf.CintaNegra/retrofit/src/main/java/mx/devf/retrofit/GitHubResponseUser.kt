package mx.devf.retrofit

/**
 * Created by Luis Rios on 26/10/17.
 */
data class GitHubResponseUser (val login: String, val id: Long, val company: String) {}

data class GitHubResponseRepo(val name: String,val full_name: String ,val id : Long) {}
