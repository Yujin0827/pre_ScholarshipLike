package com.cookandroid.scholarshiplike
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MagazineAdapter (private var list: MutableList<TestData>): ListAdapter<TestData, MagazineAdapter.MagazineItemViewHolder>(DiffCallback){
    // inner class로 ViewHolder 정의
    inner class MagazineItemViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {

        var data1Text: TextView = itemView!!.findViewById(R.id.data1Text)
        var data2Text: TextView = itemView!!.findViewById(R.id.data2Text)
        var data3Text: TextView = itemView!!.findViewById(R.id.data3Text)

        // onBindViewHolder의 역할을 대신한다.
        fun bind(data: TestData, position: Int) {
            Log.d("ListAdapter", "===== ===== ===== ===== bind ===== ===== ===== =====")
            Log.d("ListAdapter", data.getData1()+" "+data.getData2()+" "+data.getData3())
            data1Text.text = data.getData1()
            data2Text.text = data.getData2()
            data3Text.text = data.getData3()
        }
    }

    // ViewHolder에게 item을 보여줄 View로 쓰일 item_data_list.xml를 넘기면서 ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagazineItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.like_content_item, parent, false)
        return MagazineItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    // ViewHolder의 bind 메소드를 호출한다.
    override fun onBindViewHolder(holder: MagazineAdapter.MagazineItemViewHolder, position: Int) {
        Log.d("ListAdapter", "===== ===== ===== ===== onBindViewHolder ===== ===== ===== =====")
        holder.bind(list[position], position)
    }
}

object DiffCallback : DiffUtil.ItemCallback<TestData>() {
    override fun areItemsTheSame(
        oldItem: TestData,
        newItem: TestData
    ): Boolean {
        return oldItem.getData1() == newItem.getData1()
    }

    override fun areContentsTheSame(
        oldItem: TestData,
        newItem: TestData
    ): Boolean {
        return oldItem == newItem
    }
}