package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.row_adapter_view_model.*

class MainActivity2 : AppCompatActivity() {
    var mList:ArrayList<User2> = ArrayList()
    var adapterViewModel:AdapterViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        init()
    }

    private fun init() {

        var myViewModel = ViewModelProviders.of(this).get(MyViewModelApi::class.java)
        var liveData = myViewModel.getData()
        liveData?.observe(this, object:Observer<ArrayList<User2>>{
            override fun onChanged(t: ArrayList<User2>?) {
                mList = t!!
            }

        })
        adapterViewModel = AdapterViewModel(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterViewModel
    }
}