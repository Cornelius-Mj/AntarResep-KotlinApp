package com.example.uniquelux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_search_page.*

class SearchPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_search_page)

        searchpg_searchbox.setOnClickListener{
            val IntentSearch = Intent(this, CategoryPage::class.java)
            startActivity(IntentSearch)
        }
    }
}