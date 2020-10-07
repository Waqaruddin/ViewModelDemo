package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onStart() {
        super.onStart()
        Log.d("abc", "Main Start")

    }

    override fun onPause() {
        super.onPause()
        Log.d("abc", "Main Pause")

    }

    override fun onResume() {
        super.onResume()
        Log.d("abc", " Main Resume")

    }

    override fun onStop() {
        super.onStop()
        Log.d("abc", " Main Stop")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("abc", " Main Create")

        init()
    }



    private fun init() {

        // without view model
//                var randomNumberGenerator = RandomNumberGenerator()
//        text_view_number.text = randomNumberGenerator.getNumber()

        // with viewModel
//        var myViewModel =  ViewModelProviders.of(this).get(MyViewModel::class.java)
//        text_view_number.text = myViewModel.getNumber()

        // with live data
        var myViewModel = ViewModelProviders.of(this).get(ViewModelWithLiveData::class.java)
        var liveData = myViewModel.getNumber()
        liveData?.observe(this, object:Observer<String>{
            override fun onChanged(t: String?) {
                text_view_number.text = t
            }

        })
        button_send.setOnClickListener {
            myViewModel.createNumber()

        }

    }

}