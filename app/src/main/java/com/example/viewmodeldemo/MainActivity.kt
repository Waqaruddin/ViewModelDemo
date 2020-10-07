package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        init()
    }

    private fun init() {

        // without view model
        //        var randomNumberGenerator = RandomNumberGenerator()
//        text_view_number.text = randomNumberGenerator.getNumber()

        // with viewModel

       var myViewModel =  ViewModelProviders.of(this).get(MyViewModel::class.java)
        text_view_number.text = myViewModel.getNumber()
    }
}