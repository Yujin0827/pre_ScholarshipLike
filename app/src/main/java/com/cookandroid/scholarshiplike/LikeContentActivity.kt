package com.cookandroid.scholarshiplike

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_like_content.*

class LikeContentActivity : AppCompatActivity() {

    var dataList: ArrayList<TestData> = arrayListOf(
        TestData("첫 번째 데이터1", "두 번째 데이터1", "세 번째 데이터1"),
        TestData("첫 번째 데이터2", "두 번째 데이터2", "세 번째 데이터2"),
        TestData("첫 번째 데이터3", "두 번째 데이터3", "세 번째 데이터3"),
        TestData("첫 번째 데이터4", "두 번째 데이터4", "세 번째 데이터4"),
        TestData("첫 번째 데이터5", "두 번째 데이터5", "세 번째 데이터5"),
        TestData("첫 번째 데이터6", "두 번째 데이터6", "세 번째 데이터6"),
        TestData("첫 번째 데이터7", "두 번째 데이터7", "세 번째 데이터7"),
        TestData("첫 번째 데이터8", "두 번째 데이터8", "세 번째 데이터8"),
        TestData("첫 번째 데이터9", "두 번째 데이터9", "세 번째 데이터9"),
        TestData("첫 번째 데이터10", "두 번째 데이터10", "세 번째 데이터10"),
        TestData("첫 번째 데이터11", "두 번째 데이터11", "세 번째 데이터11"),
        TestData("첫 번째 데이터12", "두 번째 데이터12", "세 번째 데이터12"),
        TestData("첫 번째 데이터13", "두 번째 데이터13", "세 번째 데이터13"),
        TestData("첫 번째 데이터14", "두 번째 데이터14", "세 번째 데이터14"),
        TestData("첫 번째 데이터15", "두 번째 데이터15", "세 번째 데이터15")
    )

    var dataList2: ArrayList<TestData> = arrayListOf(
        TestData("첫 번째 데이터15", "두 번째 데이터1", "세 번째 데이터1"),
        TestData("첫 번째 데이터14", "두 번째 데이터2", "세 번째 데이터2"),
        TestData("첫 번째 데이터13", "두 번째 데이터3", "세 번째 데이터3"),
        TestData("첫 번째 데이터12", "두 번째 데이터4", "세 번째 데이터4"),
        TestData("첫 번째 데이터11", "두 번째 데이터5", "세 번째 데이터5"),
        TestData("첫 번째 데이터10", "두 번째 데이터6", "세 번째 데이터6"),
        TestData("첫 번째 데이터9", "두 번째 데이터7", "세 번째 데이터7"),
        TestData("첫 번째 데이터8", "두 번째 데이터8", "세 번째 데이터8"),
        TestData("첫 번째 데이터7", "두 번째 데이터9", "세 번째 데이터9"),
        TestData("첫 번째 데이터6", "두 번째 데이터10", "세 번째 데이터10"),
        TestData("첫 번째 데이터5", "두 번째 데이터11", "세 번째 데이터11"),
        TestData("첫 번째 데이터4", "두 번째 데이터12", "세 번째 데이터12"),
        TestData("첫 번째 데이터3", "두 번째 데이터13", "세 번째 데이터13"),
        TestData("첫 번째 데이터2", "두 번째 데이터14", "세 번째 데이터14"),
        TestData("첫 번째 데이터1", "두 번째 데이터15", "세 번째 데이터15")
    )



    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 데이터 1 보내기
        val transactionScholar = supportFragmentManager.beginTransaction()
        transactionScholar.replace(R.id.like_viewpager, LikeContentScholarshipFragment())
        transactionScholar.commit()
        intent.putExtra("DataList", dataList)

        // 데이터 2 보내기
        val transactionMagazine = supportFragmentManager.beginTransaction()
        transactionMagazine.replace(R.id.like_viewpager, LikeContentMagazineFragment())
        transactionMagazine.commit()
        intent.putExtra("DataList2", dataList2)

        // 페이지 어댑터
        val adapter = LikeContentPageAdapter(supportFragmentManager)
        adapter.addFragment(LikeContentScholarshipFragment(), "장학금")
        adapter.addFragment(LikeContentMagazineFragment(), "매거진")
        like_viewpager.adapter = adapter
        like_tabLayout.setupWithViewPager(like_viewpager)
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
