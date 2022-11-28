package com.example.practice6_3

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val t1 : TextView = findViewById(R.id.t1)
        val t2 : TextView = findViewById(R.id.t2)
        val t3 : TextView = findViewById(R.id.t3)
        val t4 : TextView = findViewById(R.id.t4)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val number = intent.getStringExtra("number")
        val address = intent.getStringExtra("address")
        val etc = intent.getStringExtra("etc")

        t1.text = "${name},${age}"
        t2.text = "${number}"
        t3.text = "${address}"
        t4.text = "${etc}"
    }
}