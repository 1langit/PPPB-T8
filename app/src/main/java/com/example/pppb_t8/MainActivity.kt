package com.example.pppb_t8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.pppb_t8.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        with(binding) {
            viewPager.adapter = TabAdapter(this@MainActivity)
            viewPager2 = viewPager
            TabLayoutMediator(tabLayout, viewPager) {
                tab, position ->
                tab.text = when(position) {
                    0 -> "Register"
                    1 -> "Login"
                    else -> ""
                }
            }.attach()
        }
    }

    fun navigateToRegister() {
        viewPager2.setCurrentItem(0, true)
    }

    fun navigateToLogin() {
        viewPager2.setCurrentItem(1, true)
    }
}