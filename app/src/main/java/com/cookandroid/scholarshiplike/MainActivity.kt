package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
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
                        changeFragment(scholartab)
                    }
                    R.id.magazineTab -> {
                        changeFragment(magazinetab)
                    }
                    R.id.profileTab -> {
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