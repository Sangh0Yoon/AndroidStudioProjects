package com.example.practice9_4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var option : SharedPreferences
    lateinit var userInfo : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        option = getSharedPreferences("alarm", MODE_PRIVATE)
        userInfo = getSharedPreferences("name", MODE_PRIVATE)

        save.setOnClickListener {
            userInfo.edit(){
                putString("name",ed.text.toString())
                ed.setText("")
            }
            Toast.makeText(this,"저장 완료.", Toast.LENGTH_SHORT).show()
        }

        vSwitchAlarm.setOnClickListener{
            option.edit{
                putBoolean("alarm", vSwitchAlarm.isChecked)
            }
        }
        vBtnMoveActivity.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        saveValueLoad()
        super.onStart()
    }

    private fun saveValueLoad(){
        ed.setText(userInfo.getString("name", ""))

        vSwitchAlarm.isChecked = option.getBoolean("alarm", false)
    }
}