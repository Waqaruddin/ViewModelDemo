package com.example.viewmodeldemo

data class UsersNameResponse(
    val count: Int,
    val data: ArrayList<User2>,
    val error: Boolean
)

data class User2(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val landlordEmail: String,
    val name: String,
    val password: String,
    val type: String
)