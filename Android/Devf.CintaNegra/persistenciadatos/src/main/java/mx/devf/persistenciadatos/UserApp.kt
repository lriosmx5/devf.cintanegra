package mx.devf.persistenciadatos

import io.realm.RealmObject
import io.realm.annotations.*

/**
 * Created by Luis Rios on 23/10/17.
 */
open class UserApp : RealmObject() {
    var name :String? = null
    var lastname : String? = null
    var age: Int? = null
    var direccion : String? = null

    @PrimaryKey
    @Required
    var id : Int? = null
}