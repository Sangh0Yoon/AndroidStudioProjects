package com.example.practice7_5

import MyPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.practice7_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val datas = mutableListOf<String>()
        for(i in 1..1){datas.add("Item $i")}

        binding.viewpager.adapter = MyPagerAdapter(datas)
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        toggle = ActionBarDrawerToggle(this,binding.drawer,
            R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        val fragButton = findViewById<Button>(R.id.fragBut1)
        val fragmentManager: FragmentManager = supportFragmentManager
        var onClicked = false
        fragButton.setOnClickListener {
            if(onClicked){
                onClicked = false
                val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                val frameLayout = supportFragmentManager.findFragmentById(R.id.fragment_content)
                transaction.remove(frameLayout!!).commit()
            }
            else{
                onClicked = true
                val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                transaction.add(R.id.fragment_content, OneFragment()).commit()
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){return true}
        return super.onOptionsItemSelected(item)
    }
}