package com.example.sharedreferencesdemo

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedreferencesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        binding.btnGet.setOnClickListener {
            val value = sharedPreferences.getString("username", "")
            binding.textView.text = value
        }

        binding.btnSet.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("username", "What")
            editor.commit()
        }
    }
}