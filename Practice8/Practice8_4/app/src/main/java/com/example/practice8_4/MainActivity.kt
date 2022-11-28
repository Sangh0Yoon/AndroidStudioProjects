package com.example.practice8_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.practice8_4.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
    var sum : Int = 0; var sec : Int = 0; var min : Int = 0; var hour : Int = 0
    var result : String = ""
    private val channel = Channel<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.start.setOnClickListener{
            backgroundScope.launch {
                var timeTask = timer(period = 10){
                    sum++
                    if(sum/100 == 1){
                        sec++; sum = 0
                    }
                    if(sec==60){
                        min++; sec=0
                    }
                    if(min==60){
                        hour++; min=0
                    }
                    result = "$hour:$min:$sec"
                    runOnUiThread{
                        binding.textView.text = result
                    }
                }
                binding.stop.setOnClickListener {
                    timeTask?.cancel()
                    sec = 0; min = 0; hour = 0;
                    result = "$hour:$min:$sec"
                    runOnUiThread{
                        binding.textView.text = result
                    }
                }
                binding.pause.setOnClickListener {
                    timeTask?.cancel()
                    binding.resume.setOnClickListener {
                        timeTask = timer(period = 10) {
                            sum++
                            if (sum / 100 == 1) {
                                sec++; sum = 0
                            }
                            if (sec == 60) {
                                min++; sec = 0
                            }
                            if (min == 60) {
                                hour++; min = 0
                            }
                            result = "$hour:$min:$sec"
                            runOnUiThread {
                                binding.textView.text = result
                            }
                        }
                    }
                }
            }
        }

        val mainScope = GlobalScope.launch(Dispatchers.Main){
            channel.consumeEach {
                binding.textView.text = "$it"
            }
        }
    }
}