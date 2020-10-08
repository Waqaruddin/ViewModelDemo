package com.example.viewmodeldemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModelApi : ViewModel() {
    var mList: MutableLiveData<ArrayList<User2>>? = null

    fun getData(): MutableLiveData<ArrayList<User2>>? {

        if (mList == null) {
            mList = MutableLiveData()


            var api = MyApi()
            api.getUsers()
                .enqueue(object : Callback<UsersNameResponse> {
                    override fun onResponse(
                        call: Call<UsersNameResponse>,
                        response: Response<UsersNameResponse>
                    ) {
                        Log.d("abc", response.body().toString())
                        mList?.value = response.body()?.data
                    }

                    override fun onFailure(call: Call<UsersNameResponse>, t: Throwable) {

                    }

                })
        }
        return mList

    }
}