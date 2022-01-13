package com.example.uniquelux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog

class RecipesActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_recipes)

        val buttonMoveSatu = findViewById<Button>(R.id.MoveToDetail_1)
        buttonMoveSatu.setOnClickListener(this)

        val buttonFilter = findViewById<TextView>(R.id.Recipes_filterBtn)
        buttonFilter.setOnClickListener(this)

        buttonFilter.setOnClickListener {
            Toast.makeText(this, "Filter is in process, hanya ada 1 mneu", Toast.LENGTH_SHORT).show()
        }

        /*
        val buttonMoveDua = findViewById<Button>(R.id.MoveToDetail_2)
        buttonMoveDua.setOnClickListener(this)

        val buttonMoveTiga = findViewById<Button>(R.id.MoveToDetail_3)
        buttonMoveTiga.setOnClickListener(this)

         */
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.MoveToDetail_1 -> {
                val moveIntentPertama = Intent(this@RecipesActivity, MenuActivitySatu::class.java)
                startActivity(moveIntentPertama)
            }

            /*
            R.id.MoveToDetail_2 -> {
                val moveIntentKedua = Intent(this@RecipesActivity, MenuActivityDua::class.java)
                startActivity(moveIntentKedua)
            }
            R.id.MoveToDetail_3 -> {
                val moveIntentKetiga = Intent(this@RecipesActivity, MenuActivityTiga::class.java)
                startActivity(moveIntentKetiga)
            }

             */
        }
    }
}