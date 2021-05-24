package com.cookandroid.scholarshiplike

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MagazineTabAdapter(val postlist: ArrayList<Post>) : RecyclerView.Adapter<MagazineTabAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.magazinetab_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = postlist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = postlist.get(position).title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.titleText) //타이틀
    }

}