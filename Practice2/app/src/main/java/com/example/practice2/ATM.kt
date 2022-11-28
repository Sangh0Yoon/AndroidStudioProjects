package com.example.practice2
import java.util.Scanner

fun print_option(){
    println("----선택하세요----")
    println("|(I) 계좌정보\t\t|")
    println("|(D) 입금\t\t|")
    println("|(W) 출금\t\t|")
    println("|(E) 종료\t\t|")
    println("----------------")
}

enum class Grade{ A,B,C,D,E,F; }
class MyAccount constructor(){
    var name: String = "kim"
    var money: Int = 0
    var grade: Grade = Grade.C
    var cnt: Int = 0
    fun Deposite(dm: Int){
        money += dm
        if (money >= 0)
            upGrade()
        println("$dm 원을 입금하였습니다. 잔액 : $money")
    }
    fun Withdraw(wm: Int){
            money -= wm

            if (money < 0 && money >= -1000) {
                println("계좌가 마이너스 되었습니다.")
                downGrade()
            }
            if (money < -1000) {
                println("잔액이 부족합니다.")
                return
            }
            println("$wm 원을 출금하였습니다. 잔액 : $money")
    }
    fun upGrade(){
        if(grade==Grade.F) {
            grade=Grade.E
            println("동결계좌가 열렸습니다.")
            println("신용등급이 'F->E'로 한단계 상승합니다.")
        }
        else if(grade==Grade.E) {
            grade = Grade.D
            println("신용등급이 'E->D'로 한단계 상승합니다.")
        }
        else if(grade==Grade.D) {
            grade = Grade.C
            println("신용등급이 'D->C'로 한단계 상승합니다.")
        }
        else if(grade==Grade.C) {
            grade = Grade.B
            println("신용등급이 'C->B'로 한단계 상승합니다.")
        }
        else if(grade==Grade.B) {
            grade = Grade.A
            println("신용등급이 'B->A'로 한단계 상승합니다.")
        }
    }
    fun downGrade(){
        if(grade==Grade.A) {
            grade = Grade.B
            println("신용등급이 'A->B'로 한단계 떨어집니다.")
        }
        else if(grade==Grade.B) {
            grade = Grade.C
            println("신용등급이 'B->C'로 한단계 떨어집니다.")
        }
        else if(grade==Grade.C) {
            grade = Grade.D
            println("신용등급이 'C->D'로 한단계 떨어집니다.")
        }
        else if(grade==Grade.D) {
            grade = Grade.E
            println("신용등급이 'D->E'로 한단계 떨어집니다.")
        }
        else if(grade==Grade.E) {
            grade = Grade.F
            println("신용등급이 'E->F'로 한단계 떨어집니다.")
        }
        else if(grade==Grade.F) {
            println("최저 등급의 신용을 가지고 있습니다.")
            println("계좌가 동결됩니다.")
            cnt++
        }
    }
    fun info(){
        println("계자정보는 다음과 같습니다.")
        println("|이름:\t\t$name |")
        println("|계좌잔액:\t\t$money |")
        println("|신용등급:\t\t$grade |")
        println("-----------------------")
    }
}

fun main(){
    var myAccount = MyAccount()

    var state: Boolean = true
    var cmd: String = ""
    var m: Int = 0

    val sc: Scanner = Scanner(System.`in`)
    while(state){
        print_option()
        cmd = sc.nextLine()
        when(cmd){
            "I" -> myAccount.info()
            "D" -> {println("입금하실 금액을 말하세요.")
                        m = sc.nextLine().toInt()
                        myAccount.Deposite(m)}
            "W" -> {    if(myAccount.grade==Grade.F&&myAccount.cnt==1) {
                println("동결된 계좌에서 출금하실 수 없습니다.")
                continue
            }
                        println("출금하실 금액을 말하세요.")
                        m = sc.nextLine().toInt()
                        myAccount.Withdraw(m)}
            "E" -> state = false
        }
    }

}