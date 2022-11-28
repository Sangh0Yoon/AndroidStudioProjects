package com.example.practice9_3

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {
    val databaseName = "movie"
    var database : SQLiteDatabase? = null
    val tableName = "movie_reserved"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doButton1.setOnClickListener {
            createDatabase()
            createTable()
            saveMovie()
        }
        doButton2.setOnClickListener {
            loadMovie()
        }
    }

    fun createDatabase(){
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null)
    }

    fun createTable(){
        val sql = "create table if not exists ${tableName}" +
                "(id integer PRIMARY KEY autoincrement, " +
                "name text, " +
                "poster_image text, " +
                "director text, " +
                "synopsis text, " +
                "reserved_time text)"
        if(database == null) return
        database?.execSQL(sql)
    }

    fun saveMovie() {
        val posterImageUri = savePosterToFile(R.drawable.movie)

        val name = "'${input1.text.toString()}'"
        val reserved_time = "'${input2.text.toString()}'"
        val director = "'${input3.text.toString()}'"
        val synopsis = "'${input4.text.toString()}'"
        val poster_image = "'${posterImageUri.toString()}'"

        addData(name,poster_image, director, synopsis, reserved_time)
    }

    fun savePosterToFile(drawable:Int) : Uri {
        val drawable = ContextCompat.getDrawable(applicationContext,drawable)
        val bitmap = (drawable as BitmapDrawable).bitmap

        val wrapper = ContextWrapper(applicationContext)
        val imagesFolder = wrapper.getDir("images", Context.MODE_PRIVATE)
        val file = File(imagesFolder, "movie.png")

        try{
            val stream : OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        }catch (e: IOException){
            e.printStackTrace()
        }
        return Uri.parse(file.absolutePath)
    }

    fun addData(name:String, poster_image:String, director:String,synopsis:String, reserved_time:String){
        val sql = "insert into ${tableName} (name,poster_image,director,synopsis,reserved_time)" +
                "values($name,$poster_image,$director,$synopsis,$reserved_time)"
        if(database == null){
            println("데이터베이스를 먼저 오픈하세요\n")
            return
        }
        database?.execSQL(sql)
        println("데이터 추가함\n")
    }

    fun loadMovie(){
        val movies = queryData()

        val intent = Intent(this,ReservedActivity::class.java)
        intent.putExtra("movies",movies)
        startActivity(intent)
    }

    fun queryData():ArrayList<ReservedMovie>?{
        val sql = "select id,name,poster_image,director,synopsis,reserved_time from ${tableName}"

        if(database == null){
            println("데이터베이스를 먼저 오픈하세요.\n")
            return null
        }
        val list = arrayListOf<ReservedMovie>()
        val cursor = database?.rawQuery(sql,null)
        if(cursor!=null){
            for(index in 0 until cursor.count){
                cursor.moveToNext()
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val poster_image = cursor.getString(2)
                val director = cursor.getString(3)
                val synopsis = cursor.getString(4)
                val reserved_time = cursor.getString(5)
                println("레코드#${index}: $id, $name, $poster_image, $director, $synopsis, $reserved_time\n")

                val movie = ReservedMovie(id,name,poster_image,director,synopsis,reserved_time)
                list.add(movie)
            }
            if(cursor.count == 0){ }
            cursor.close()
        }
        println("데이터 조회함\n")
        return list
    }
}