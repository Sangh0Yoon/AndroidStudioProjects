package com.example.practice6_4

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val iv_name = findViewById<ImageView>(R.id.iv_profile2)
        val ev_name = findViewById<TextView>(R.id.ev_name2)
        val ev_age = findViewById<TextView>(R.id.ev_age2)
        val ev_phone = findViewById<TextView>(R.id.ev_phone2)
        val ev_address = findViewById<TextView>(R.id.ev_address2)
        val ev_guitar = findViewById<TextView>(R.id.ev_guitar2)
        val end = findViewById<Button>(R.id.btn_end)
        val bitmap = intent.getParcelableExtra<Bitmap>("image")
        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val phone = intent.getStringExtra("phone")
        val address = intent.getStringExtra("address")
        val guitar = intent.getStringExtra("guitar")
        iv_name.setImageBitmap(bitmap)
        ev_name.text = name
        ev_age.text = age
        ev_phone.text = phone
        ev_address.text = address
        ev_guitar.text = guitar
        end.setOnClickListener {
            finish()
        }
    }
}