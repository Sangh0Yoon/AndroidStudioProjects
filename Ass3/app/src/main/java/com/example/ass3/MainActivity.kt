package com.example.ass3

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    val GALLERY = 1
    lateinit var resize : Bitmap
    lateinit var btn : Button; lateinit var name : EditText;
    lateinit var engName : EditText; lateinit var phone: EditText;
    lateinit var address: EditText; lateinit var email: EditText
    lateinit var photo: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById<Button>(R.id.btn_save)
        name = findViewById<EditText>(R.id.ev_name)
        engName = findViewById<EditText>(R.id.ev_EngName)
        phone = findViewById<EditText>(R.id.ev_number)
        email = findViewById<EditText>(R.id.ev_email)
        address = findViewById<EditText>(R.id.ev_address)
        photo = findViewById<ImageView>(R.id.iv_profile)
        photo.isClickable = true
        photo.setOnClickListener{
            openGallery()
        }
        btn.setOnClickListener {
            val intent = Intent(this,Subactivity::class.java)
            intent.putExtra("image",resize)
            intent.putExtra("name",name.text.toString())
            intent.putExtra("engName",engName.text.toString())
            intent.putExtra("phone",phone.text.toString())
            intent.putExtra("email",email.text.toString())
            intent.putExtra("address",address.text.toString())
            startActivityForResult(intent,2)
        }
    }
    private fun openGallery(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent,GALLERY)
    }
    private fun resizeBitmap(bitmap: Bitmap,width:Int,height:Int):Bitmap{
        return Bitmap.createScaledBitmap(
            bitmap,
            height,
            width,
            false
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            when(requestCode){
                1 -> {
                    val imageData : Uri? = data?.data
                    try{
                        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageData)
                        val pt = findViewById<ImageView>(R.id.iv_profile)
                        pt.setImageBitmap(bitmap)
                        resize = resizeBitmap(bitmap,200,200)
                    } catch (e:Exception){
                        e.printStackTrace()
                    }
                }
                2 -> {
                    var s = data!!.getStringExtra("end").toString()
                }
            }
        }
    }
}