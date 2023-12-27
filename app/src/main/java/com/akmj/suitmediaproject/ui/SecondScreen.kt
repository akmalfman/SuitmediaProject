package com.akmj.suitmediaproject.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.akmj.suitmediaproject.databinding.ActivitySecondScreenBinding

class SecondScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = "Second Screen"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val username = intent.getStringExtra("username")
        binding.tvName.text = username

        val selected = intent.getStringExtra("selected_username")
        binding.tvSelectedUser.text = selected

        binding.btnChooseUser.setOnClickListener{
            val intent = Intent(this, ThirdScreen::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish() // Close the current activity and go back
                return true
            }
            // Handle other menu items if needed
        }
        return super.onOptionsItemSelected(item)
    }
}