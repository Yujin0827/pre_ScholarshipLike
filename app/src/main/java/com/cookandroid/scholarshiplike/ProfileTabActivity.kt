package com.cookandroid.scholarshiplike

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.profiletab.*

class ProfileTabActivity : Fragment() {

    lateinit var myConChange : LinearLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.profiletab, container, false)

        myConChange = view.findViewById<LinearLayout>(R.id.myConChange)

//        //'내 조건 수정' 클릭 리스너 - MyConChangeActivity 실행
//        myConChange.setOnClickListener {
//            activity?.let {
//                val intent = Intent(context, MyConChangeActivity::class.java)
//                startActivity(intent)
//            }
//        }

//        myConChange.setOnClickListener(object :View.OnClickListener {
//            override fun onClick(v: View?) {
//                val intent = Intent(getActivity(), MyConChangeActivity::class.java)
//                startActivity(intent)
//                // 다른 액티비티에서 전환할 때
//                activity?.finish()
//            }
//        })

        return view
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        //'내 조건 수정' 클릭 리스너 - MyConChangeActivity 실행
        myConChange.setOnClickListener {
            activity?.let {
                val intent = Intent(it, MyConChangeActivity::class.java)
                it?.startActivity(intent)
            }
        }
        super.onActivityCreated(savedInstanceState)
    }
}