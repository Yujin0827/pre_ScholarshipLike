package com.cookandroid.scholarshiplike

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class MainActivity : AppCompatActivity() {

    private BottomNavigationView tabNav;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private HomeTabActivity homeTab;
    private ScholarshipTabActivity scholarTab;
    private MagazineTabActivity magazineTab;
    private ProfileTabActivity profileTab;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}