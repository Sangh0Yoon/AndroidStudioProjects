package com.example.practice3
// a~z : 97~122
// A~Z : 65~90
fun change(str: String) : String{
    var sz : Int = str.length
    var result : String = ""
    var error : String = "error with = "
    var state : Int = 0
    for(i:Int in 0 until sz step(1)){
        if(str[i].code in 123 downTo 96){
            result += str[i].uppercaseChar()
            state++
        }
        else{
            error += str[i]
        }
    }
    if(state == sz)
        return result
    else
        return error
}

fun main(){
    var a = "abcd"
    println(change(a))

    var b = "EfgH"
    println(change(b))

    var c = "!@%$"
    println(change(c))
}