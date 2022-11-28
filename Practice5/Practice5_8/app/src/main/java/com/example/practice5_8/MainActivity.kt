package com.example.practice5_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var btn0 : Button; lateinit var btn1 : Button
    lateinit var btn2 : Button; lateinit var btn3 : Button
    lateinit var btn4 : Button; lateinit var btn5 : Button
    lateinit var btn6 : Button; lateinit var btn7 : Button
    lateinit var btn8 : Button; lateinit var btn9 : Button
    lateinit var btnStar : Button; lateinit var btnShap : Button
    lateinit var del : ImageView
    lateinit var edit : EditText
    var str : String = ""
    var clickTime : Long = 0L
    var cnt : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn0 = findViewById<Button>(R.id.btn0)
        btn1 = findViewById<Button>(R.id.btn1)
        btn2 = findViewById<Button>(R.id.btn2)
        btn3 = findViewById<Button>(R.id.btn3)
        btn4 = findViewById<Button>(R.id.btn4)
        btn5 = findViewById<Button>(R.id.btn5)
        btn6 = findViewById<Button>(R.id.btn6)
        btn7 = findViewById<Button>(R.id.btn7)
        btn8 = findViewById<Button>(R.id.btn8)
        btn9 = findViewById<Button>(R.id.btn9)
        btnStar = findViewById<Button>(R.id.btnStar)
        btnShap = findViewById<Button>(R.id.btnShap)
        edit = findViewById<EditText>(R.id.edit)
        del = findViewById<ImageView>(R.id.delete)

        del.setOnClickListener{
            var len = str.length
            if(len==1){
                edit.setText("")
            }
            else {
                if (str.slice(len - 2 until len - 1).equals("-")) {
                    str = str.slice(0 until len - 2)
                } else {
                    str = str.slice(0 until len - 1)
                }
                edit.setText(str)
            }
        }
        btn0.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "0"
            edit.setText(str)
            cnt++
        }
        btn1.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                cnt=4}
            }
            str += "1"
            edit.setText(str)
            cnt++
        }
        btn2.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "2"
            edit.setText(str)
            cnt++
        }
        btn3.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "3"
            edit.setText(str)
            cnt++
        }
        btn4.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "4"
            edit.setText(str)
            cnt++
        }
        btn5.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "5"
            edit.setText(str)
            cnt++
        }
        btn6.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "6"
            edit.setText(str)
            cnt++
        }
        btn7.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "7"
            edit.setText(str)
            cnt++
        }
        btn8.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "8"
            edit.setText(str)
            cnt++
        }
        btn9.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "9"
            edit.setText(str)
            cnt++
        }
        btnStar.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "*"
            edit.setText(str)
            cnt++
        }
        btnShap.setOnClickListener{
            when(cnt){
                3 -> {str+="-"
                    cnt = 4}
                8 ->{str+="-"
                    cnt=4}
            }
            str += "#"
            edit.setText(str)
            cnt++
        }

    }
}