package com.example.vkproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vkproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenSecond.setOnClickListener { openSecondActivity() }
        binding.btnCallFriend.setOnClickListener { dialPhoneNumber() }
        binding.btnShareText.setOnClickListener { shareText() }
    }

    private fun openSecondActivity() {
        val text = binding.etInput.text.toString().trim()
        if (text.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_empty_text), Toast.LENGTH_SHORT).show()
            binding.etInput.error = getString(R.string.error_empty_text)
            return
        }
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(SecondActivity.EXTRA_TEXT, text)
        }
        startActivity(intent)
    }

    private fun dialPhoneNumber() {
        val raw = binding.etInput.text.toString().trim()
        if (!isValidPhoneNumber(raw)) {
            Toast.makeText(this, getString(R.string.error_invalid_phone), Toast.LENGTH_SHORT).show()
            binding.etInput.error = getString(R.string.error_invalid_phone)
            return
        }
        val phone = raw.replace(" ", "").replace("-", "")
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, getString(R.string.error_no_dialer), Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidPhoneNumber(input: String): Boolean {
        if (input.length !in 5..20) return false
        val regex = Regex("^[+]?[0-9\\s\\-()]+$")
        return regex.matches(input) && input.count { it.isDigit() } >= 5
    }

    private fun shareText() {
        val text = binding.etInput.text.toString().trim()
        if (text.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_empty_text), Toast.LENGTH_SHORT).show()
            binding.etInput.error = getString(R.string.error_empty_text)
            return
        }
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_subject))
        }
        startActivity(Intent.createChooser(intent, getString(R.string.share_chooser_title)))
    }
}