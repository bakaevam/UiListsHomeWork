package com.homework.uilistshomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homework.uilistshomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = fragmentAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}
