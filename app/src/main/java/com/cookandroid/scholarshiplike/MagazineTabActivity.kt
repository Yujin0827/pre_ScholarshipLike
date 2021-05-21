package com.cookandroid.scholarshiplike

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.magazinetab.*

class MagazineTabActivity : Fragment() {

    private var firestore : FirebaseFirestore? = null// Firestore 인스턴스
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
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.magazinetab, container, false)

        Log.v("OnCreateView", "ENTER")

//            // ArrayList 비워줌
//            postList?.clear()
//
//            for (snapshot in querySnapshot!!.documents) {
//                var item = snapshot.toObject(Post::class.java)
//                postList?.add(item!!)
//            }
//        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v("OnViewCreated", "ENTER")

//        val postList = arrayListOf(
//            Post("대학생에게 추천하는 체크카드 TOP10"),
//            Post("자취방 전기세 아끼는 법"),
//            Post("소비를 줄여주는 좋은 습관들"),
//            Post("대학 졸업까지 1억 모으기"),
//            Post("안녕하세요 김민지입니당")
//        )
        magazinerecyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        magazinerecyclerView.setHasFixedSize(true) //리사이클러뷰 성능 개선 방안

        magazinerecyclerView.adapter = MagazineTabAdapter(postList)
    }
}