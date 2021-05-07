package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 실행시 툴바 호출 (hometab에만 적용)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("장학라이크")
        // title 장학라이크로 설정


        setFrag(0) // 첫 화면 = homeTabActivity


    }

    //하단바 교체가 일어나는 실행문
    private fun setFrag(fragNum : Int) {
        val ft = supportFragmentManager.beginTransaction()

        when(fragNum) {
            0 -> {
                ft.replace(R.id.nav, HomeTabActivity()).commit()
            }
            1 -> {
                ft.replace(R.id.nav, ScholarshipTabActivity()).commit()
            }
            2 -> {
                ft.replace(R.id.nav, MagazineTabActivity()).commit()
            }
            3 -> {
                ft.replace(R.id.nav, ProfileTabActivity()).commit()
            }
        }
    }
}