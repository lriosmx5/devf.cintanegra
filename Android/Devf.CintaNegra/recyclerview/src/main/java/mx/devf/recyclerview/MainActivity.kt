package mx.devf.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog



class MainActivity : AppCompatActivity(), MyRecyclerAdapter.OnItemClickListener {

    override fun onItemClick(position: Int, item: ItemClass) {

        //Toast.makeText(this, "Click en $position - ${item.title}", Toast.LENGTH_SHORT).show()
        MaterialDialog.Builder(this)
                .title(item.title)
                .content(item.description)
                .positiveText("Aceptar")
                .show()
    }

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    fun setupRecyclerView()
    {
        recyclerView = findViewById(R.id.recyclerView)
        //recyclerView?.layoutManager  = LinearLayoutManager(this)
        recyclerView?.layoutManager  = GridLayoutManager(this, 2)
        recyclerView?.isVerticalScrollBarEnabled = true


        val adapter = MyRecyclerAdapter(getListItems(), this)
        recyclerView?.adapter = adapter
    }

    fun getListItems() : List<ItemClass> {
        return listOf<ItemClass>(
                ItemClass("Titulo 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
                ItemClass("Otro titulo", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
                ItemClass("Que mas da", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
                ItemClass("Que mas da", "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                ItemClass("Titulo 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
                ItemClass("Otro titulo", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
                ItemClass("Y otro y otro", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
                ItemClass("Que mas da", "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                ItemClass("Titulo 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
                ItemClass("Otro titulo", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
                ItemClass("Que mas da", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
                ItemClass("Y otro y otro", "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                ItemClass("Titulo 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
                ItemClass("Otro titulo", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
                ItemClass("Que mas da", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
                ItemClass("Que mas da", "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                ItemClass("Titulo 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
                ItemClass("Otro titulo", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
                ItemClass("Y otro y otro", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
                ItemClass("Que mas da", "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                ItemClass("Titulo 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
                ItemClass("Otro titulo", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
                ItemClass("Que mas da", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
                ItemClass("Y otro y otro", "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        )
    }

}
