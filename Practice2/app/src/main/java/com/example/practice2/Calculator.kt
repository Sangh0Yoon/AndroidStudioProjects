package com.example.practice2

class Calculator constructor(){
    var result : MutableList<Float> = mutableListOf()
    var cnt: Int = 0
    var state: Boolean = false
    fun cal(v1: Float, v2: Float, cmd: String){
        when(cmd) {
            in "add" -> add1(v1,v2)
            in "substract" -> substract(v1,v2)
            in "multiple" -> multiple(v1,v2)
            in "division" -> division(v1,v2)
        }
    }
    fun add1(v1: Float, v2: Float){
        var sum: Float = v1 + v2
        result.add(sum)
        cnt++
    }
    fun substract(v1: Float, v2: Float){
        result.add(v1-v2)
        cnt++
    }
    fun multiple(v1: Float, v2: Float){
        result.add(v1*v2)
        cnt++
    }
    fun division(v1: Float, v2: Float){
        if(v2 == 0.0F)
            state = true
        else{
            result.add(v1/v2)
            cnt++
        }
    }
    fun print_calculated_number(){
        if(state) {
            println("ERROR : number can not be divided with zero.")
            state = false
        }
        else
            println(result[cnt - 1])
    }
    fun load(){
        for(i in 0 until cnt step(1))
            println(result[i])
    }
}

fun main(){
    var calculator = Calculator()
    calculator.cal(1.0F,2.0F,"add")
    calculator.print_calculated_number()
    calculator.cal(1.0F,10.0F,"substract")
    calculator.print_calculated_number()
    calculator.cal(1.0F,0.0F,"division")
    calculator.print_calculated_number()
    calculator.cal(1.0F,10.0F,"division")
    calculator.print_calculated_number()
    calculator.cal(1.0F,10.0F,"multiple")
    calculator.print_calculated_number()
    println("----------------------")
    calculator.load()
}