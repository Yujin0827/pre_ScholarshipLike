package com.cookandroid.scholarshiplike

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.scholarshiplike.databinding.LikecontentItemBinding
import java.text.SimpleDateFormat

class RecyclerViewAdapter: RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<likeContent_data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = LikecontentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val likeData = listData.get(position)
        holder.setLikeData(likeData)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}

class Holder(val binding: LikecontentItemBinding):RecyclerView.ViewHolder(binding.root){
    fun setLikeData(likeData: likeContent_data){
        binding.textNo.text = "${likeData.no}"
        binding.textTitle.text = likeData.title

        var sdf = SimpleDateFormat("yyyy/mm/dd")
        var formattedDate = sdf.format(likeData.timestamp)
        binding.textDate.text = formattedDate
    }

}

