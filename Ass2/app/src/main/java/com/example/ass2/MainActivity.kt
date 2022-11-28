package com.example.ass2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var btnAdd : Button; lateinit var btnSub : Button
    lateinit var btnMul : Button; lateinit var btnDiv : Button
    lateinit var btnRest : Button; lateinit var btnChange : Button
    lateinit var textResult : TextView
    var cnt : Int = 0
    var num1 : Int? = null; var num2 : Int? = null
    var clickTime : Long = 0L

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cnt = 0
        title = "${cnt}회 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)

        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        btnRest = findViewById<Button>(R.id.BtnRest)
        btnChange = findViewById<Button>(R.id.BtnChange)
        textResult = findViewById<TextView>(R.id.TextResult)

        btnAdd.setOnTouchListener { view, motionEvent ->
            if(SystemClock.elapsedRealtime() - clickTime > 500){
                if(edit1.text.toString() == "" || edit2.text.toString() == "") {
                    textResult.text = "빈칸채워주세요."
                }
                else{
                    title = "${++cnt}회 계산기"
                    num1 = edit1.text.toString().toInt()
                    num2 = edit2.text.toString().toInt()
                    num1 = num1!! + num2!!
                    edit1.setText(num1.toString())
                    edit2.setText(null)
                    textResult.text = "계산 결과 : " + num1.toString()
                }
            }
            clickTime = SystemClock.elapsedRealtime()
            false
        }
        btnSub.setOnTouchListener{view, motionEvent ->
            if(SystemClock.elapsedRealtime() - clickTime > 500){
                if(edit1.text.toString() == "" || edit2.text.toString() == "") {
                    textResult.text = "빈칸채워주세요."
                }
                else {
                    title = "${++cnt}회 계산기"
                    num1 = edit1.text.toString().toInt()
                    num2 = edit2.text.toString().toInt()
                    num1 = num1!! - num2!!
                    edit1.setText(num1.toString())
                    edit2.setText(null)
                    textResult.text = "계산 결과 : " + num1.toString()
                }
            }
            clickTime = SystemClock.elapsedRealtime()
            false
        }
        btnMul.setOnTouchListener{view, motionEvent ->
            if(SystemClock.elapsedRealtime() - clickTime > 500){
                if(edit1.text.toString() == "" || edit2.text.toString() == "") {
                    textResult.text = "빈칸채워주세요."
                }
                else {
                    title = "${++cnt}회 계산기"
                    num1 = edit1.text.toString().toInt()
                    num2 = edit2.text.toString().toInt()
                    num1 = num1!! * num2!!
                    edit1.setText(num1.toString())
                    edit2.setText(null)
                    textResult.text = "계산 결과 : " + num1.toString()
                }
            }
            clickTime = SystemClock.elapsedRealtime()
            false
        }
        btnDiv.setOnTouchListener{view, motionEvent ->
            if(SystemClock.elapsedRealtime() - clickTime > 500){
                if(edit1.text.toString() == "" || edit2.text.toString() == "") {
                    textResult.text = "빈칸채워주세요."
                }
                else {
                    title = "${++cnt}회 계산기"
                    num1 = edit1.text.toString().toInt()
                    num2 = edit2.text.toString().toInt()
                    num1 = num1!! / num2!!
                    edit1.setText(num1.toString())
                    edit2.setText(null)
                    textResult.text = "계산 결과 : " + num1.toString()
                }
            }
            clickTime = SystemClock.elapsedRealtime()
            false
        }
        btnRest.setOnTouchListener{view, motionEvent ->
            if(SystemClock.elapsedRealtime() - clickTime > 500){
                if(edit1.text.toString() == "" || edit2.text.toString() == "") {
                    textResult.text = "빈칸채워주세요."
                }
                else {
                    title = "${++cnt}회 계산기"
                    num1 = edit1.text.toString().toInt()
                    num2 = edit2.text.toString().toInt()
                    num1 = num1!! % num2!!
                    edit1.setText(num1.toString())
                    edit2.setText(null)
                    textResult.text = "계산 결과 : " + num1.toString()
                }
            }
            clickTime = SystemClock.elapsedRealtime()
            false
        }
        btnChange.setOnTouchListener{view, motionEvent ->
            if(SystemClock.elapsedRealtime() - clickTime > 500) {
                if(edit1.text.toString() == "" || edit2.text.toString() == "") {
                    textResult.text = "빈칸채워주세요."
                }
                else {
                    title = "${cnt}회 계산기"
                    num1 = edit1.text.toString().toInt()
                    num2 = edit2.text.toString().toInt()
                    var t1: Int = num1!!
                    var t2: Int = num2!!
                    edit1.setText(num2.toString())
                    edit2.setText(num1.toString())
                }
            }
            clickTime = SystemClock.elapsedRealtime()
            false
        }
    }
}