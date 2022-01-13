package com.example.uniquelux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uniquelux.databinding.ActivityCategoryPageBinding
import kotlinx.android.synthetic.main.activity_category_page.*

class CategoryPage : AppCompatActivity() {
    private lateinit var binding : ActivityCategoryPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_page)

        KategoriBtn_Semua.setOnClickListener {
            val IntentKategori = Intent(this, RecipesActivity::class.java)
            startActivity(IntentKategori)
        }
        KategoriBtn_Sarapan.setOnClickListener {
            val IntentKategori = Intent(this, RecipesActivity::class.java)
            startActivity(IntentKategori)
        }
        KategoriBtn_Vegan.setOnClickListener {
            val IntentKategori = Intent(this, RecipesActivity::class.java)
            startActivity(IntentKategori)
        }
    }
}