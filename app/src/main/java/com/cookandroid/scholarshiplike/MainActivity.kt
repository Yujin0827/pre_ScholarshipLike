package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.util.Log
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

}