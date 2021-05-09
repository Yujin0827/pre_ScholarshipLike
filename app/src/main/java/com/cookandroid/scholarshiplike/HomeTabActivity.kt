package com.cookandroid.scholarshiplike

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/*
class HomeTabActivity : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.hometab, container, false)

        return view
    }
}
*/

class HomeTabActivity : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.myToolbar.inflateMenu(R.menu.sample_menu)


    }
}