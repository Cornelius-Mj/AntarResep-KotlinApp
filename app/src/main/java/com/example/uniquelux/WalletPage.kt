package com.example.uniquelux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_wallet_page.*

class WalletPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet_page)
        supportActionBar?.hide()

        walletpg_intentSearch.setOnClickListener {
            val moveintent = Intent(this, SearchPage::class.java)
            startActivity(moveintent)
        }
    }
}