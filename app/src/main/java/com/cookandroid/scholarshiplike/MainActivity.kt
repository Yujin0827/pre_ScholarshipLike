package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFrag(0) // 첫 화면 = homeTabActivity

        boolean onNavigationItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {

            }
            return true;
        }

    }

    //하단바 교체가 일어나는 실행문
    private fun setFrag(fragNum : Int) {
        val ft = supportFragmentManager.beginTransaction()

        when(fragNum)
        {
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

            //test
        }
    }
}