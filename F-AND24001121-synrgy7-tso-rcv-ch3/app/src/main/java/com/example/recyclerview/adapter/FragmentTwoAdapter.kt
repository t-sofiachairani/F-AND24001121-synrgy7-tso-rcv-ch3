package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class FragmentTwoAdapter(private val dataContent :List<String>,private val listener : onClick) : RecyclerView.Adapter<FragmentTwoAdapter.Viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return dataContent.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = dataContent[position]

        holder.content.text = item
        holder.itemView.setOnClickListener {
            listener.click(item)
        }
    }

    class Viewholder(view : View) : RecyclerView.ViewHolder(view){
        val content = view.findViewById<TextView>(R.id.tv_itemlist)
    }

    interface onClick{
        fun click(data : String)
    }

}