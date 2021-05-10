package com.cookandroid.scholarshiplike

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.content.Context
import android.view.View
import android.widget.*

class likeContentAdapter(context: Context, list: ArrayList<*>) : ArrayAdapter<Any?>(context, 0, list), OnItemClickListener {
    override fun onItemClick(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
    }

    internal inner class ViewHolder {
        var tv_name: TextView
        var tv_summary: TextView = null
        var iv_thumb: ImageView = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView: View? = convertView
        val viewHolder: ViewHolder
        if (convertView == null) {
            val layoutInflater = LayoutInflater.from(parent.context)
            convertView = layoutInflater.inflate(R.layout.row_item, parent, false)
        }
        viewHolder = ViewHolder()
        viewHolder.tv_name = convertView.findViewById(R.id.textView_name)
        viewHolder.tv_summary = convertView.findViewById(R.id.textView_summary)
        viewHolder.iv_thumb = convertView.findViewById(R.id.imageView_thumb) as ImageView
        val actor: Actor = list[position] as Actor
        viewHolder.tv_name.setText(actor.getName())
        viewHolder.tv_summary.setText(actor.getSummary())
        Glide
            .with(context)
            .load(actor.getThumb_url())
            .centerCrop()
            .apply(RequestOptions().override(250, 350))
            .into(viewHolder.iv_thumb)
        viewHolder.tv_name!!.tag = actor.getName()


//        //아이템 클릭 방법2 - 클릭시 아이템 반전 효과가 안 먹힘
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, " " + actor.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

        //Return the completed view to render on screen
        return convertView
    }

    init {
        this.context = context
        this.list = list
    }

}


