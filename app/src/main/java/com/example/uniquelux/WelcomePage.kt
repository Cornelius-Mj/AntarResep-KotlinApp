package com.example.uniquelux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_welcome_page.*

class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_welcome_page)

        btnEnter.setOnClickListener {
            Toast.makeText(this, "Button Enter Pressed", Toast.LENGTH_SHORT).show()
            val LoginPage1 = Intent(this, LoginPage::class.java)
            startActivity(LoginPage1)
        }
    }
}