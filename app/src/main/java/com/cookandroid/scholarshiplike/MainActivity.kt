package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.magazinetab_item.view.*


open class MainActivity : AppCompatActivity() {

    //탭 화면 변수 생성
    private val hometab = HomeTabActivity()
    private val scholarshiptab = ScholarshipTabActivity()
    private val magazinetab = MagazineTabActivity()
    private val profiletab = ProfileTabActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //툴바 설정
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        changeFragment(hometab)     //첫 화면 = hometab
        initNavigationBar()

    }



    //하단바 누르면 탭 화면 전환
    private fun initNavigationBar() {
        tabNav.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.homeTab -> {
                        changeFragment(hometab)
                    }
                    R.id.scholarshipTab -> {
                        changeFragment(scholarshiptab)
                    }
                    R.id.magazineTab -> {
                        changeFragment(magazinetab)
                        //메인 액티비티 데이터를 프래그먼트로 넘겨줌
                        intent.putExtra("DataList", dataList)
                    }
                    R.id.profileTab -> {
                        changeFragment(profiletab)
                    }
                }
                true
            }

            //test
        }
    }

    //하단바 - 탭 화면(프래그먼트) 연결
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.nav, fragment).commit()
    }

    //매거진 임시 데이터
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

}

//매거진 테스트 데이터 클래스
class TestData(
    private var data1: String? = null,
    private var data2: String? = null,
    private var data3: String? = null
){
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