package com.example.podcastapp.activities

fun calculate(second : Int) : String{
    val secondInMinute = 60
    val minute = second / secondInMinute
    val result = second % secondInMinute
    var totaltime = ""
    if(minute > 9 && result > 9){
        totaltime = "$minute : $result"
    }else if(minute < 10 && result > 9){
        totaltime = "0$minute : $result"
    }else if(minute > 9 && result < 10){
        totaltime = "$minute : 0$result"
    }else {
        totaltime = "0$minute : 0$result"
    }
    return totaltime
}

fun main(){
    println(calculate(567))
    println(calculate(0))
}