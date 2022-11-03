package com.kush.newsfresh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

@Suppress("DEPRECATION")
class NewsListAdapter(private val items: ArrayList<String>, private val listner: Selectlistner) : RecyclerView.Adapter<NewsViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newsview,parent,false)
        val viewholder = NewsViewholder(view)

        view.setOnClickListener{
            listner.onItemClicked(items[viewholder.adapterPosition])
        }

        return viewholder
    }

    override fun onBindViewHolder(holder: NewsViewholder, position: Int) {
        val currentItem = items[position]
        holder.title.text = currentItem

    }

    override fun getItemCount(): Int {
       return items.size
    }

}
class NewsViewholder(ItemView:View): RecyclerView.ViewHolder(ItemView){
    val title : TextView = itemView.findViewById(R.id.title)

}
interface Selectlistner{
    fun onItemClicked(item:String)
}