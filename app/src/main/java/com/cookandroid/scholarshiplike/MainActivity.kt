package com.cookandroid.scholarshiplike

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

open class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener  {

    lateinit var tabNav : BottomNavigationView

    // onBackPressed 메소드 변수
    var backPressedTime : Long = 0
    val FINISH_INTERVAL_TIME = 2000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        tabNav = findViewById<BottomNavigationView>(R.id.tabNav)

        // 툴바 설정
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav, HomeTabActivity(), "homeTab")
            .commit()

        // 하단바
        tabNav.setOnNavigationItemSelectedListener(this)
    }

    // 하단바 누르면 탭 화면 전환 & BackStack 생성 및 제거
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        val fm = supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()

        when(p0.itemId){
            R.id.homeTab -> {
                fm.popBackStack("homeTab", FragmentManager.POP_BACK_STACK_INCLUSIVE)    // BackStack에서 해당 fragment 제거
                val hometab = HomeTabActivity()                            // fragment 변수 생성
                transaction.replace(R.id.nav, hometab, "homeTab")     // fragment 화면 전환
                transaction.addToBackStack("homeTab")               // fragment 생성하면서 BackStack 생성
            }
            R.id.scholarshipTab -> {
                fm.popBackStack("scholarshipTab", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                val scholarshiptab = ScholarshipTabActivity()
                transaction.replace(R.id.nav, scholarshiptab, "scholarshipTab")
                transaction.addToBackStack("scholarshipTab")
            }
            R.id.magazineTab -> {
                fm.popBackStack("magazineTab", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                val magazinetab = MagazineTabActivity()
                transaction.replace(R.id.nav, magazinetab, "magazineTab")
                transaction.addToBackStack("magazineTab")
            }
            R.id.profileTab -> {
                fm.popBackStack("profileTab", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                val profiletab = ProfileTabActivity()
                transaction.replace(R.id.nav, profiletab, "profileTab")
                transaction.addToBackStack("profileTab")
            }
        }

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
        transaction.isAddToBackStackAllowed

        return true
    }

    // fragment 클릭했을 때 자동적으로 하단바 아이콘 변경 ( 뒤로가기 눌렀을 때 호출 )
    private fun updateBottomMenu(navigation: BottomNavigationView) {
        val homeTab: Fragment? = supportFragmentManager.findFragmentByTag("homeTab")
        val scholarshipTab: Fragment? = supportFragmentManager.findFragmentByTag("scholarshipTab")
        val magazineTab: Fragment? = supportFragmentManager.findFragmentByTag("magazineTab")
        val profileTab: Fragment? = supportFragmentManager.findFragmentByTag("profileTab")

        if(homeTab != null && homeTab.isVisible) {navigation.menu.findItem(R.id.homeTab).isChecked = true }
        if(scholarshipTab != null && scholarshipTab.isVisible) {navigation.menu.findItem(R.id.scholarshipTab).isChecked = true }
        if(magazineTab != null && magazineTab.isVisible) {navigation.menu.findItem(R.id.magazineTab).isChecked = true }
        if(profileTab != null && profileTab.isVisible) {navigation.menu.findItem(R.id.profileTab).isChecked = true }

    }

    // back 버튼 클릭 리스너 재정의
    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 0) {
            val tempTime = System.currentTimeMillis()
            val intervalTime = tempTime - backPressedTime

            if (!(0 > intervalTime || FINISH_INTERVAL_TIME < intervalTime)) {
                finishAffinity()
                System.runFinalization()
                System.exit(0)
            } else {
                backPressedTime = tempTime
                Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
                return
            }
        }
        super.onBackPressed()

        val tabNav = findViewById<View>(R.id.tabNav) as BottomNavigationView
        updateBottomMenu(tabNav)
    }

}