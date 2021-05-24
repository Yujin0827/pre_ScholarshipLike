package com.cookandroid.scholarshiplike

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MagazineTabAdapter(val postlist: ArrayList<Post>) : RecyclerView.Adapter<MagazineTabAdapter.MagazineViewHolder>() {

    //뷰홀더 생성 때 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagazineViewHolder {
        //연결 레이아웃 설정
        val view = LayoutInflater.from(parent.context).inflate(R.layout.magazinetab_item, parent, false)
        return MagazineViewHolder(view)
    }

    override fun getItemCount(): Int = postlist.size

    override fun onBindViewHolder(holder: MagazineViewHolder, position: Int) {
        holder.title.text = postlist.get(position).title

    }

    class MagazineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.titleText) //타이틀
    }

}