package com.example.week2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var N = readLine().toInt()

    var T = IntArray(N + 10)
    var P = IntArray(N + 10)
    var db = IntArray(N + 10)

    var max = 0

    for(i in 0 until N) {
        var input = readLine()!!.split(" ").map{it.toInt()}

        T.set(i,input[0])
        P.set(i,input[1])

        if (db[i]==0&&i+input[0]<=N) {
            if (i != 0) {
                max = db[i-1]+ input[1]
            }
            else max = input[1]

            for(j in i until i+input[0]){
                db[j]=max
            }
        }

    }

    println(max)

    close()
}