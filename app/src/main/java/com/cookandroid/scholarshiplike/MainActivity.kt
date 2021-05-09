package com.cookandroid.scholarshiplike

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


open class MainActivity : AppCompatActivity() {

    //탭 화면 변수 생성
    private val hometab = HomeTabActivity()
    private val scholartab = ScholarshipTabActivity()
    private val magazinetab = MagazineTabActivity()
    private val profiletab = ProfileTabActivity()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 실행시 툴바 호출
        var toolbar = findViewById<Toolbar>(R.id.mytoolbar)
        setSupportActionBar(toolbar)

        // title 장학라이크로 설정
        initNavigationBar()
    }

    //하단바 누르면 탭 화면 전환
    private fun initNavigationBar() {
        tabNav.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.hometab -> {
                        changeFragment(hometab)
                    }

                    R.id.scholarshiptab -> {
                        changeFragment(scholartab)
                    }
                    R.id.magazinetab -> {
                        changeFragment(magazinetab)
                    }
                    R.id.profiletab -> {
                        changeFragment(profiletab)
                    }
                }
                true
            }
        }
    }

    //하단바 - 탭 화면(프래그먼트) 연결
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.nav, fragment).commit()
    }

}