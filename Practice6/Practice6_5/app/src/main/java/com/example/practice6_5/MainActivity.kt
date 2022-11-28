package com.example.practice6_5

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.SimPhonebookContract
import android.text.Editable
import android.util.Log
import android.widget.*
import java.lang.Exception
import java.net.Inet4Address
import java.net.URI

class MainActivity : AppCompatActivity() {
    val GALLERY = 1
    lateinit var resize : Bitmap
    lateinit var btn : Button; lateinit var name : EditText;
    lateinit var age : EditText; lateinit var phone:EditText;
    lateinit var address: EditText; lateinit var guitar:EditText
    lateinit var photo:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById<Button>(R.id.btn_save)
        name = findViewById<EditText>(R.id.ev_name)
        age = findViewById<EditText>(R.id.ev_age)
        phone = findViewById<EditText>(R.id.ev_phone)
        address = findViewById<EditText>(R.id.ev_address)
        guitar = findViewById<EditText>(R.id.ev_guitar)
        photo = findViewById<ImageView>(R.id.iv_profile)
        photo.isClickable = true
        photo.setOnClickListener {
            openGallery()
        }
        btn.setOnClickListener {
            val intent = Intent(this,SubActivity::class.java)
            intent.putExtra("image",resize)
            intent.putExtra("name",name.text.toString())
            intent.putExtra("age",age.text.toString())
            intent.putExtra("phone",phone.text.toString())
            intent.putExtra("address",address.text.toString())
            intent.putExtra("guitar",guitar.text.toString())
            startActivityForResult(intent,2)
        }
    }
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent,GALLERY)
    }
    private fun resizeBitmap(bitmap:Bitmap,width:Int,height:Int):Bitmap{
        return Bitmap.createScaledBitmap(
            bitmap,
            height,
            width,
            false
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                1 -> {
                    val imageData :Uri? = data?.data
                    try{
                        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageData)
                        val pt = findViewById<ImageView>(R.id.iv_profile)
                        pt.setImageBitmap(bitmap)
                        resize = resizeBitmap(bitmap,300,300)
                    } catch (e:Exception) {
                        e.printStackTrace()
                    }
                }
                2 -> {
                    val end = data!!.getIntExtra("end",0)
                    Log.e("end?",end.toString())
                    if (end == 3) {
                        name.setText("")
                        age.setText("")
                        phone.setText("")
                        address.setText("")
                        guitar.setText("")
                        photo.setImageResource(R.drawable.ic_launcher_background)
                    }
                }
            }
        }
    }
}