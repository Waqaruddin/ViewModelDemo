package com.example.viewmodeldemo

import java.util.*


class RandomNumberGenerator {

    var randomNumber:String? = null
    fun createNumber(){
        var random = Random()
        var number = random.nextInt(10-1)+1
        randomNumber = "Number  $number"

    }

    fun getNumber():String?{
        if(randomNumber == null){
            createNumber()
        }
        return randomNumber

    }
}