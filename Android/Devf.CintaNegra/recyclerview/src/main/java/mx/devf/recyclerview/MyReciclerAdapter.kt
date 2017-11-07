package mx.devf.recyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.zip.Inflater

/**
 * Created by Luis Rios on 24/10/17.
 */
class MyRecyclerAdapter(val elements : List<ItemClass>, val listener : MyRecyclerAdapter.OnItemClickListener?= null)
    : RecyclerView.Adapter<MyRecyclerAdapter.MyRecyclerHolder>() {

    //private var elements : List<ItemClass> = elements

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: MyRecyclerHolder?, position: Int) {
        val element = elements[position]
        holder?.tvTitle?.text = element.title
        holder?.tvDescription?.text = element.description
        //holder?.itemView?.setOnClickListener{ Log.e("MyLog","Click en $position") }
        holder?.itemView?.setOnClickListener {
            listener?.onItemClick(position, element)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyRecyclerHolder {
        var rowView = LayoutInflater.from(parent?.context).inflate(R.layout.row_item, parent, false)

        return MyRecyclerHolder(rowView)
    }

    class MyRecyclerHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle : TextView? = null
        var tvDescription : TextView? = null
        var imgIcon: ImageView? = null

        init {
            tvTitle = itemView.findViewById(R.id.txtTitle)
            tvDescription = itemView.findViewById(R.id.txtDescription)
            imgIcon = itemView.findViewById(R.id.imgIcon)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position:Int, item: ItemClass)
    }
}