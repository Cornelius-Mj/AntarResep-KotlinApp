package com.example.uniquelux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.uniquelux.menu_detail.MenuPrice1
import com.example.uniquelux.menu_detail.MenuRecipes1
import kotlinx.android.synthetic.main.activity_menu_satu.*

class MenuActivitySatu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_menu_satu)

        val MenuPricePg1 = MenuPrice1()
        val MenuRecipesPg1 = MenuRecipes1()

        setCurrentFragment(MenuPricePg1)

        Menu_Navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_price -> setCurrentFragment(MenuPricePg1)
                R.id.ic_recipes -> setCurrentFragment(MenuRecipesPg1)
            }
            true
        }
    }
    fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FlM1Fragment, fragment)
            commit()
        }
    }
}