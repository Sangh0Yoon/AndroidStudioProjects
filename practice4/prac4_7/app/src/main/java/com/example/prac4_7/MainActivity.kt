package com.example.prac4_7


import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var right : Button; lateinit var left : Button
    lateinit var imageView : ImageView
    var index: Int  = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arr = intArrayOf(R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,
            R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,
            R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z)
        title = "조류 갤러리"

        imageView = findViewById(R.id.imageView)
        right = findViewById(R.id.right)
        left = findViewById(R.id.left)

        right.setOnClickListener {
            if (index == 25) index = 0
            else index++
            imageView.setImageResource(arr[index])
        }
        left.setOnClickListener {
            if (index == 0) index = 25
            else index--
            imageView.setImageResource(arr[index])
        }
    }

}