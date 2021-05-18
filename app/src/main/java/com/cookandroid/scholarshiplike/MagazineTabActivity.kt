package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.magazinetab.*
import kotlinx.android.synthetic.main.magazinetab_item.view.*

class MagazineTabActivity : Fragment() {

    private lateinit var magazineAdapter: MagazineTabAdapter // 리사이클러뷰 어댑터


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.magazinetab, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //메인 액티비티의 데이터를 프래그먼트로 넘겨받음
        var list: ArrayList<TestData> = requireActivity().intent!!.extras!!.get("DataList") as ArrayList<TestData>
        Log.e("FirstFragment", "Data List: ${list}")

        // Fragment에서 전달받은 list를 넘기면서 ListAdapter 생성
        magazineAdapter = MagazineTabAdapter(list)
        MagazineRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        // RecyclerView.adapter에 지정
        MagazineRecyclerView.adapter = magazineAdapter
    }
}