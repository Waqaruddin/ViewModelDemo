package com.example.viewmodeldemo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET

interface MyApi {

    @GET("auth/login")
    fun getUsers(): Call<UsersNameResponse>

    companion object {
        operator fun invoke() : MyApi {
            return Retrofit.Builder()
                .baseUrl("https://apolis-property-management.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}