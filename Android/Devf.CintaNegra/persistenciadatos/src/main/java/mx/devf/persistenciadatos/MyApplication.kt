package mx.devf.persistenciadatos

import android.app.Application
import android.content.res.Configuration
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by Luis Rios on 23/10/17.
 * Se define en el manifiesto para que se utilice por toda la aplicacion
 * android:name=".MyApplication"
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val config = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)

    }
}