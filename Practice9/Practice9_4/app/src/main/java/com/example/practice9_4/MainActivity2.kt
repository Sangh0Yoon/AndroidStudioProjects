package com.example.practice9_4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CpuUsageInfo
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    lateinit var option : SharedPreferences
    lateinit var userInfo: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        option = getSharedPreferences("alarm", Context.MODE_PRIVATE)
        userInfo = getSharedPreferences("name", Context.MODE_PRIVATE)

        var str = """User Name: ${userInfo.getString("name", "NULL")}
            |
            |Alarm On/Off: ${boolToText(option.getBoolean("alarm", false))}
        """.trimMargin()

         vTextResult.text = str
    }

    fun boolToText(check: Boolean): String{
        return when(check){
            true -> "On"
            else -> "Off"
        }
    }
}