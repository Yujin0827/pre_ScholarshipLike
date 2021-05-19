package com.cookandroid.scholarshiplike

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.scholarshiptab.*

class ScholarshipTabActivity : Fragment() {

   //lateinit var context : Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.scholarshiptab, container, false)



        fun onCreate(savedInstanceState: Bundle?)
        {
            super.onCreate(savedInstanceState)
     //       setContentView(R.layout.scholarshiptab)


       //     val adapter = MyPagerAdapter(supportFragmentManager)
         //   adapter.addFragment(FragmentMyScholar(), "내 장학금")
           // adapter.addFragment(FragmentKoreaScholar(), "전체 장학금")

            //cholarShipViewpager.adapter = adapter
            scholarShipTabBar.setupWithViewPager(scholarShipViewpager)
        }

        return view
    }




}