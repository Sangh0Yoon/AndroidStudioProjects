package com.example.practice6_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name: EditText = findViewById(R.id.name)
        val age: EditText = findViewById(R.id.age)
        val number: EditText = findViewById(R.id.number)
        val address: EditText = findViewById(R.id.address)
        val etc: EditText = findViewById(R.id.etc)
        val btn: Button = findViewById(R.id.btn)

        btn.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("name", name.text.toString())
            intent.putExtra("age", age.text.toString())
            intent.putExtra("number", number.text.toString())
            intent.putExtra("address", address.text.toString())
            intent.putExtra("etc", etc.text.toString())
            name.text = null
            age.text = null
            number.text = null
            address.text = null
            etc.text = null
            startActivity(intent)
        }
    }
}