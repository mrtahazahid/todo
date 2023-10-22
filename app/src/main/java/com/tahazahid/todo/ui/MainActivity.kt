package com.tahazahid.todo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tahazahid.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCallList.setOnClickListener {
            startActivity(Intent(this, CallActivity::class.java))
        }

        binding.btnBuyList.setOnClickListener {
            startActivity(Intent(this, BuyActivity::class.java))
        }

        binding.btnSellList.setOnClickListener {
            startActivity(Intent(this, SellActivity::class.java))
        }
    }
}