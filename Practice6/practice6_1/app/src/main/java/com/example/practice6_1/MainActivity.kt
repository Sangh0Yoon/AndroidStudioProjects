package com.example.practice6_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Week6ExampleL1"

        val btn: Button = findViewById(R.id.btn_main)

        btn.setOnClickListener {
            val intent = Intent(this,SubActivity::class.java)
            startActivity(intent)
        }
    }
}