package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.magazinetab.*

class MagazineTabActivity : Fragment() {

    private var firestore : FirebaseFirestore? = null // Firestore 인스턴스
    var postList : ArrayList<Post> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.v("OnCreate", "ENTER")

        //매거진관련
        firestore = FirebaseFirestore.getInstance() // Firestore 인스턴스 초기화

        firestore?.collection("장학라이크")?.document("매거진")?.collection("금융")?.get()?.addOnSuccessListener { result ->
            // 성공할 경우
            postList?.clear()

            for (document in result) {  // 가져온 문서들은 result에 들어감
                val item = Post(document["title"] as String)
                postList?.add(item)
            }
            Log.d("postList", postList.toString())
            magazinerecyclerView.adapter?.notifyDataSetChanged()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.magazinetab, container, false)

        Log.v("OnCreateView", "ENTER")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v("OnViewCreated", "ENTER")

        magazinerecyclerView.layoutManager = LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false)
        magazinerecyclerView.setHasFixedSize(true) //리사이클러뷰 성능 개선 방안

        magazinerecyclerView.adapter = MagazineTabAdapter(postList)
    }
}