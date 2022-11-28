package com.example.pratice4_7

import java.util.*

fun isdigit(input : String): Boolean {
    var st : Boolean = true
    for(i in 0 until (input.length) step(1)){
        var tmp : Char = input[i]
        st = Character.isDigit(tmp) != false
    }
    return st
}

class Machine constructor(){
    fun getChange(money : Int, price : Int) :Int?{
        if((money-price)<0){
            return null
        }
        else{
            return (money-price)
        }
    }
    fun getCoin(sc : Scanner): Int? {
        println("Insert coin")
        var money = sc.nextLine()
        if(!isdigit(money)){
            return null
        }
        else{
            println("${money} 원을 넣었습니다.")
            return money.toInt()
        }
    }
    fun getMenu(sc : Scanner, menu : String) :Boolean?{
        if(menu=="1"||menu=="2"||menu=="3"||menu=="4"||menu=="5"){
            when(menu){
                "1" -> println("참께라면이 선택되었습니다.")
                "2" -> println("햄버거가 선택되었습니다.")
                "3" -> println("콜라가 선택되었습니다.")
                "4" -> println("핫바가 선택되었습니다.")
                "5" -> println("초코우유가 선택되었습니다.")
            }
            var price = getPrice(menu)
            var money = getCoin(sc)
            while(money==null){
                println("돈을 넣지 않았습니다.")
                println("다시 돈을 넣어주세요.")
                money = getCoin(sc)
            }
            var change = money?.let { getChange(it,price) }
            if(change == null){
                println("현금이 부족합니다.")
            }else{
                println("감사합니다. 잔돈반환:${change}")
            }
            return true
        }
        else{
            println("아무것도 선택하지 않았습니다.")
            println("다시 선택해주세요.")
            return null
        }
    }
    fun getPrice(menu : String) : Int{
        var rest : Int = 0
        when(menu){
            "1" -> rest = 1000
            "2" -> rest = 1500
            "3" -> rest = 800
            "4" -> rest = 1200
            "5" -> rest = 1500
        }
        return rest
    }
}

fun main(){
    var machine = Machine()
    var state : Boolean = true
    var sc : Scanner = Scanner(System.`in`)
    while(state){
        println("=============== Menu ==============")
        println("| (1) 참께라면\t - 1,000원\t")
        println("| (2) 햄버거\t - 1,500원\t")
        println("| (3) 콜라\t -   800원\t")
        println("| (4) 핫바\t - 1,200원\t")
        println("| (5) 초코우유\t - 1,500원\t")
        println("Choose menu:")
        var cmd = sc.nextLine()
        var st  = machine.getMenu(sc,cmd)
        if(st==null){
            state = true
        }
        else{
            state = false
        }
    }
}