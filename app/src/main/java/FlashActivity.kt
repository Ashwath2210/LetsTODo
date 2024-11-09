package com.example.letstodotask

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import missing.namespace.R

class FlashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)

        // Show splash screen for 2 seconds and move to Home Screen
        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()  // Close splash screen activity
        }, 2000) // 2-second delay
    }
}
