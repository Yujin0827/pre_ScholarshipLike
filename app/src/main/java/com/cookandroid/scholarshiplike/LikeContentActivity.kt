package com.cookandroid.scholarshiplike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_like_content.*

class LikeContentActivity : AppCompatActivity() {
    private var tabLayoutTextArray: ArrayList<String> = arrayListOf("매거진", "장학금")
    lateinit var viewAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like_content)

        //어댑터 생성, 연결
        viewAdapter = ViewPagerAdapter(this)
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

    fun getData2(): String? {
        return data2
    }

    fun getData3(): String? {
        return data3
    }


}
