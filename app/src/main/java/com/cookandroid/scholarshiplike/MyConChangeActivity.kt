package com.cookandroid.scholarshiplike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.cookandroid.scholarshiplike.databinding.ActivityMainBinding

class MyConChangeActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_con_change)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setupSpinnerIncome()
    }

//    private fun setupSpinnerIncome() {
//        val incomes = resources.getStringArray(R.array.incomeList)
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, incomes)
//        binding.spinnerIncome.adapter = adapter
//    }
//
//    private fun setupSpinnerHandler() {
//        binding.spinnerIncome.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                binding.txtIncome.text = "Selected: ${binding.spinnerIncome.getItemAtPosition(position)}"
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//
//            }
//        }
//    }
}
