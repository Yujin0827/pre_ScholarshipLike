package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.scholarshiptab.*
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_korea_scholar.*
import kotlinx.android.synthetic.main.scholarshiptab.*



class ScholarshipTabActivity : Fragment() {

    lateinit var like : ImageView       // 좋아요 페이지로 이동 버튼
    lateinit var alarm : ImageView      // 알람 페이지로 이동 버튼
    lateinit var myScholarButton: Button // 내 장학금 버튼
    lateinit var koreaScholarButton: Button // 전체 장학금 버튼
    private var mf = FragmentMyScholar() // 내장학금 프래그먼트
    private var kf = FragmentKoreaScholar() // 전체 장학금 프래그먼트


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.scholarshiptab, container, false)


        like = view.findViewById<ImageView>(R.id.like)              // hometab의 좋아요 버튼 변수 생성
        alarm = view.findViewById<ImageView>(R.id.alarm)            // hometab의 알람 버튼 변수 생성
        myScholarButton = view.findViewById<Button>(R.id.myScholarBt) // 내 장학금 버튼 변수 생성
        koreaScholarButton = view.findViewById<Button>(R.id.koreaScholarBt) //전체 장학금 버튼 변수 생성

        setFrag(mf)


        myScholarButton.setOnClickListener{ // 내장학금 버튼 이벤트
            setFrag(mf)
        }
        koreaScholarButton.setOnClickListener{ // 전체장학금 버튼 이벤트
            setFrag(kf)
        }

        return view
    }





    private fun setFrag(fragment : Fragment){ // 자식프래그먼트 생성
        childFragmentManager.beginTransaction().replace(R.id.scholarFram, fragment).commit()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
    // 프래그먼트 생성시 툴바 hide
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    // 프래그먼트 종료시 툴바 show
    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }





}


