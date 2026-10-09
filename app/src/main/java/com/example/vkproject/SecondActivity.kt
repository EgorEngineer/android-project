package com.example.vkproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vkproject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedText = intent.getStringExtra(EXTRA_TEXT)
        binding.tvReceivedText.text = if (receivedText.isNullOrBlank()) {
            getString(R.string.second_no_text)
        } else {
            receivedText
        }

        binding.btnBack.setOnClickListener { finish() }
    }

    companion object {
        const val EXTRA_TEXT = "extra_text"
    }
}