package mx.devf.navigationview

import android.app.Notification
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    var mDrawerToggle : ActionBarDrawerToggle? = null
    var drawerLayout : DrawerLayout? = null
    var navigationView : NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout) as DrawerLayout
        navigationView = findViewById(R.id.navigationView) as NavigationView
        setupMavigationView()
    }

    private fun setupMavigationView() {
        mDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close)
        drawerLayout!!.addDrawerListener(mDrawerToggle!!)
        navigationView?.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "Elemento seleccionado", Toast.LENGTH_LONG).show()
        drawerLayout?.closeDrawer(Gravity.START)
        if(item.isChecked == false) {
            val itemId: Int = item.itemId
            item.setChecked(true)
            navigate(itemId)
        }
        return true
    }

    fun navigate(idMenu: Int){
        when(idMenu)
        {
            R.id.nav_home ->{
                navigate(PrimerFragment())
            }
            R.id.nav_profile ->
            {
                navigate(SegundoFragment())
            }
        }
    }

    fun navigate(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .addToBackStack("ASD") //pila de regresion de navegacion
                .commit()

    }

    override fun onBackPressed() {
        //supportFragmentManager.getBackStackEntryAt(1)
        if(drawerLayout!!.isDrawerOpen(Gravity.START))
            drawerLayout!!.closeDrawer(Gravity.START)
        else
            super.onBackPressed()
        //para forzar que no se cierre al retornar se comenta
        //tamibien forzas a que no regrese a la pila
    }

}
