package com.cookandroid.scholarshiplike

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_alarm.*
import kotlinx.android.synthetic.main.activity_like_content.*

class LikeContentActivity : AppCompatActivity() {
    private var tabLayoutTextArray: ArrayList<String> = arrayListOf("매거진", "장학금")
    lateinit var viewAdapter: ViewPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like_content)

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

data class TestData(private var data1: String, private var data2: String, private var data3: String){
    fun getData1(): String? {
        return data1
    }
    fun setData1(name: String) {
        this.data1 = data1
    }

    fun getData2(): String? {
        return data2
    }
    fun setData2(address: String) {
        this.data2 = data2
    }

    fun getData3(): String? {
        return data3
    }
    fun setData3(type: String) {
        this.data3 = data3
    }
}
