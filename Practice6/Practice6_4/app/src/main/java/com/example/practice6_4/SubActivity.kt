package com.example.practice6_4

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val iv_name = findViewById<ImageView>(R.id.iv_sub)
        val ev_name = findViewById<TextView>(R.id.ev_sub_name)
        val ev_age = findViewById<TextView>(R.id.ev_sub_age)
        val ev_phone = findViewById<TextView>(R.id.ev_sub_phone)
        val ev_address = findViewById<TextView>(R.id.ev_sub_address)
        val ev_guitar = findViewById<TextView>(R.id.ev_sub_guitar)
        val btn_fix = findViewById<Button>(R.id.btn_fix)
        val btn_finish = findViewById<Button>(R.id.btn_finish)
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
        btn_fix.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("end",2)
            setResult(RESULT_OK,intent)
            finish()
        }
        btn_finish.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("image",bitmap)
            intent.putExtra("name",name)
            intent.putExtra("age",age)
            intent.putExtra("phone",phone)
            intent.putExtra("address",address)
            intent.putExtra("guitar",guitar)
            startActivityForResult(intent,3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("code",requestCode.toString())
        val mainIntent = Intent(this,MainActivity::class.java)
        mainIntent.putExtra("end",3)
        setResult(RESULT_OK,mainIntent)
        finish()
    }
}