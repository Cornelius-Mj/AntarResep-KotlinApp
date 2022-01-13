package com.example.uniquelux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        Handler().postDelayed({
            val moveintent = Intent(this@MainActivity, WelcomePage::class.java)
            startActivity(moveintent)
            finish()
        }, 2500)
    }
}