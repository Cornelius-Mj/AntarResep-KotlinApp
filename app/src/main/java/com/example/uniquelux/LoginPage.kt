package com.example.uniquelux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login_page)

        val context = this
        var username: String = edUsername.text.toString()
        var dbHelper = DBHelper(context)

        btnLogin.setOnClickListener {
            if (edUsername.text.toString().length > 0 && edPassword.text.toString().length > 0) {
                val user = User(edUsername.text.toString(),edPassword.text.toString())

                try {
                    if (dbHelper.dataIsTrue(user)) {
                        val Homepage = Intent(this, HomePage::class.java)
                        startActivity(Homepage)
                    }

                    else {
                        Toast.makeText(this, "Data not found.", Toast.LENGTH_SHORT).show()
                        openRegistrasi()
                    }
                }

                catch (e: Exception) {
                    Toast.makeText(context,e.toString(), Toast.LENGTH_LONG).show()
                }
            }
            else {
                Toast.makeText(this, "Data not found, please register.", Toast.LENGTH_SHORT).show()
                openRegistrasi()
            }
        }

        btnRegister.setOnClickListener {
            Toast.makeText(this, "Button Register Pressed", Toast.LENGTH_SHORT).show()
//            dbHelper.deleteAllData()
//            dbHelper.dropTable()
//            dbHelper.createTable()
            openRegistrasi()
        }
    }
    fun openRegistrasi(){
        val Registrasi = Intent(this, RegistrasiPage::class.java).putExtra("username", edUsername.text.toString())
        startActivity(Registrasi)
    }
}










