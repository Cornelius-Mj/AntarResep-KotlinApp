package com.example.uniquelux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrasi_page.*

class RegistrasiPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_registrasi_page)

        val context = this
        var dbHelper = DBHelper(context)

        btnRegistrasi.setOnClickListener {
            if (edEmail.text.toString().length > 0 && edUsername.text.toString().length > 0
                && edPassword.text.toString().length > 0 && edKonfirmPw.text.toString().length > 0 &&
                (edPassword.text.toString() == edKonfirmPw.text.toString())) {
                var user = User(edEmail.text.toString(), edUsername.text.toString(), edPassword.text.toString())

                dbHelper.insertData(user)

                Toast.makeText(context, "Registered succesfully, please log in!", Toast.LENGTH_SHORT).show()

                val LoginPage1 = Intent(this, LoginPage::class.java)
                startActivity(LoginPage1)
            }

            else {
                Toast.makeText(context, "Please fill correctly.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}