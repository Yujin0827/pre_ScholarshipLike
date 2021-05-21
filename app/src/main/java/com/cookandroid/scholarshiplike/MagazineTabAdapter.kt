package com.cookandroid.scholarshiplike

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MagazineTabAdapter(val postlist: ArrayList<Post>) : RecyclerView.Adapter<MagazineTabAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.magazinetab_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = postlist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = postlist.get(position).title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.titleText) //타이틀
    }

    fun updateListItems(posts: List<Post>?) {
        val diffCallback = MagazineDiffCallback(
            this.postlist, posts!!
        )
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.postlist.clear()
        this.postlist.addAll(posts)
        diffResult.dispatchUpdatesTo(this)
    }
}

//디프콜백 클래스
class MagazineDiffCallback(oldList: List<Post>, newList: List<Post>) : DiffUtil.Callback() {

    private val mOldList: List<Post>
    private val mNewList: List<Post>

    override fun getOldListSize(): Int {
        return mOldList.size
    }

    override fun getNewListSize(): Int {
        return mNewList.size
    }

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return mOldList[oldItemPosition].title === mNewList[newItemPosition].title
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        val oldPost: Post = mOldList[oldItemPosition]
        val newPost: Post = mNewList[newItemPosition]
        return oldPost.title == newPost.title
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    init {
        mOldList = oldList
        mNewList = newList
    }
}

//class MagazineTabAdapter(val postlist: ArrayList<Post>) : RecyclerView.Adapter<MagazineTabAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagazineTabAdapter.ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.magazinetab_item, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return postlist.size
//    }
//
//    override fun onBindViewHolder(holder: MagazineTabAdapter.ViewHolder, position: Int) {
//        holder.title.text = postlist.get(position).title
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val title = itemView.findViewById<TextView>(R.id.titleText) //타이틀
//    }
//}