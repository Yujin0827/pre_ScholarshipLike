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
    private var mf = FragmentMyScholar()
    private var kf = FragmentKoreaScholar()




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.scholarshiptab, container, false)


        like = view.findViewById<ImageView>(R.id.like)              // hometab의 좋아요 버튼 변수 생성
        alarm = view.findViewById<ImageView>(R.id.alarm)            // hometab의 알람 버튼 변수 생성
        myScholarButton = view.findViewById<Button>(R.id.myScholarBt)
        koreaScholarButton = view.findViewById<Button>(R.id.koreaScholarBt)






        myScholarButton.setOnClickListener{
            setFrag(mf)
        }
        koreaScholarButton.setOnClickListener{
            setFrag(kf)
        }

        return view
    }





    private fun setFrag(fragment : Fragment){
        childFragmentManager.beginTransaction().replace(R.id.scholarFram, fragment).commit()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }





}



