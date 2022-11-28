package com.example.practice8_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.practice8_1.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
    var sum : Int = 0
    private val channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        backgroundScope.launch {
            delay(1000)
            var time = measureTimeMillis {
                for(i in 1..2_000_000_000){
                    sum += i
                    channel.send(sum.toInt())
                }
            }
        }
        val mainScope = GlobalScope.launch(Dispatchers.Main){
            channel.consumeEach{
                binding.tv.text = "sum : $it"
            }
        }
    }
}
