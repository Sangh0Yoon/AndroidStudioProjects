package com.example.temp

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Subactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val iv_profile = findViewById<ImageView>(R.id.iv_profile_sub)
        val t_name = findViewById<TextView>(R.id.name_sub)
        val t_engName = findViewById<TextView>(R.id.EngName_sub)
        val t_phone = findViewById<TextView>(R.id.number_sub)
        val t_email = findViewById<TextView>(R.id.email_sub)
        val t_address = findViewById<TextView>(R.id.address_sub)
        val btn_back = findViewById<Button>(R.id.btn_back)
        val bitmap = intent.getParcelableExtra<Bitmap>("image")
        val name = intent.getStringExtra("name")
        val engName = intent.getStringExtra("engName")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")
        val address = intent.getStringExtra("address")
        iv_profile.setImageBitmap(bitmap)
        t_name.text = name
        t_engName.text = engName
        t_phone.text = phone
        t_email.text = email
        t_address.text = address
        btn_back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("end",2)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}