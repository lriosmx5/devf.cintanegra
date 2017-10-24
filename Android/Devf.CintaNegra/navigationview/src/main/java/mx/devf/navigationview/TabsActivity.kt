package mx.devf.navigationview

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar


/**
 * Created by Luis Rios on 10/10/17.
 */
class TabsActivity : AppCompatActivity() {

    var toolBar: Toolbar? = null
    var viewPager : ViewPager? = null
    var tabLayout : TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        toolBar = findViewById(R.id.toolBar) as Toolbar
        viewPager = findViewById(R.id.viewPager) as ViewPager
        tabLayout = findViewById(R.id.tabsLayout) as TabLayout

        setSupportActionBar(toolBar)
        supportActionBar?.title = "Luis"
        supportActionBar?.setIcon(R.mipmap.ic_launcher_round)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PrimerFragment(), "Uno one")
        adapter.addFragment(SegundoFragment(), "Segundo two")
        adapter.addFragment(PrimerFragment(), "Tres four")
        adapter.addFragment(SegundoFragment(), "Cuatro three")
        viewPager?.adapter = adapter

        tabLayout?.setupWithViewPager(viewPager)
    }

}