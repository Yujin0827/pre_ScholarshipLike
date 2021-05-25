package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class SearchWinActivity : AppCompatActivity() {

    lateinit var goBack : ImageView         //뒤로가기 버튼
    lateinit var searchBar : EditText     //검색창
    lateinit var searchGoBtn : ImageView //찾기 버튼
    lateinit var resultList : RecyclerView  //검색 결과

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchwin)

        goBack = findViewById<ImageView>(R.id.goBack)
        searchBar = findViewById<EditText>(R.id.searchBar)      //검색창
        searchGoBtn = findViewById<ImageButton>(R.id.searchGoBtn)  //찾기 버튼
        resultList = findViewById<RecyclerView>(R.id.toolbar)   //검색 결과


    }
}