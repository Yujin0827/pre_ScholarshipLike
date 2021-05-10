package com.cookandroid.scholarshiplike

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment


class likeContent : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.like_content, container, false)

        val likeList = ArrayList<likeContentData>();
        likeList.add(likeContentData("ScholarshipName","SchoolName"))
        likeList.add(likeContentData("ScholarshipName","SchoolName"))
        likeList.add(likeContentData("ScholarshipName","SchoolName"))
        likeList.add(likeContentData("ScholarshipName","SchoolName"))
        likeList.add(likeContentData("ScholarshipName","SchoolName"))
        likeList.add(likeContentData("ScholarshipName","SchoolName"))


        val listView = rootView.findViewById<ListView>(R.id.like_list)
        val listViewAdapter = CustomAdapter

        return inflater.inflate(R.layout.like_content, container, false)
    }

}

data class likeContentData(val title: String, val name: String)
