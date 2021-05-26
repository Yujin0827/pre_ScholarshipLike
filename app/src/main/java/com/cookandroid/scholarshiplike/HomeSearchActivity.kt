package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_like_content.*

class SearchWinActivity : AppCompatActivity() {

    private var tabLayoutTextArray: ArrayList<String> = arrayListOf("매거진", "장학금")

    lateinit var viewAdapter: ViewPageAdapter
    lateinit var searchBar : EditText       //검색창
    lateinit var searchGoBtn : ImageView    //찾기 버튼

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchwin)

        searchBar = findViewById<EditText>(R.id.searchBar)          //검색창
        searchGoBtn = findViewById<ImageButton>(R.id.searchGoBtn)   //찾기 버튼

        //어댑터 생성, 연결
        viewAdapter = ViewPageAdapter(this)
        viewAdapter.addFragment(LikeContentMagazineFragment())
        viewAdapter.addFragment(LikeContentScholarshipFragment())
        like_viewpager.adapter = viewAdapter

        // 탭 레이아웃 이름 연결
        TabLayoutMediator(like_tabLayout, like_viewpager){ tab, position->
            tab.text = tabLayoutTextArray[position]
        }.attach()
    }
}