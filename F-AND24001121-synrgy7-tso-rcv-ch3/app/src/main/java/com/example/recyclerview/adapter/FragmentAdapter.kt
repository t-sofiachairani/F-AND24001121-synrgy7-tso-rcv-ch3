package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.ModelAlphabet
import com.example.recyclerview.R

class FragmentAdapter(private val list : List<ModelAlphabet>, private val listener : onClick) : RecyclerView.Adapter<FragmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position];
        holder.huruf.text = data.huruf

        holder.itemView.setOnClickListener {
            listener.clicker(data)
        }
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val huruf = view.findViewById<TextView>(R.id.tv_itemlist);
    }


    interface onClick{
        fun clicker(data : ModelAlphabet)
    }
}
