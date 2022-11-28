package com.example.practice2

import java.util.Scanner

fun main(){
    var num =0
    var pairList: MutableList<Int> = mutableListOf()

    val sc: Scanner = Scanner(System.`in`)
    num = sc.nextLine().toInt()

    for(i: Int in 0 until num step (1)){
        var temp = sc.nextLine().toInt()
        pairList.add(temp)
    }

    for(i: Int in 0 until num step(1)){
        var state: Boolean = true
        print("Pairs for ${pairList[i]} : ")
        for(j: Int in 1..12 step(1)){
            for(k: Int in 1..12 step(1)){
                if(k+j == pairList[i] && j < k){
                    if(state){
                        print("($j $k)")
                        state = false
                    }
                    else{
                        print(",($j $k)")
                    }
                }
            }
        }
        println()
    }
}