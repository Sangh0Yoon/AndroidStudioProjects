package com.example.prac4_5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var linLayer : LinearLayout
    lateinit var btn : Button
    var st : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "직접해보기 1번 문제"

        linLayer = findViewById<LinearLayout>(R.id.LinLay)
        btn = findViewById<Button>(R.id.Btn)
        btn.setOnClickListener{
            if(st==0){
                linLayer.setBackgroundColor(Color.parseColor("#FF0000"))
                st++
            }
            else if(st==1){
                linLayer.setBackgroundColor(Color.parseColor("#00FF00"))
                st++
            }
            else if(st==2){
                linLayer.setBackgroundColor(Color.parseColor("#0000FF"))
                st++
            }
            else if(st==3){
                st = 0
            }
        }
    }
}