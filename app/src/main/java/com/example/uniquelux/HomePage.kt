package com.example.uniquelux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.uniquelux.home_fragment.CartFragment
import com.example.uniquelux.home_fragment.HomeFragment
import com.example.uniquelux.home_fragment.ProfileFragment
import com.example.uniquelux.home_fragment.ShipmentFragment
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home_page)

        val frHomepage = HomeFragment()
        val frShipmentpage = ShipmentFragment()
        val frCartpage = CartFragment()
        val frProfilepage = ProfileFragment()

        setCurrentFragment(frHomepage)

        homepage_bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> setCurrentFragment(frHomepage)
                R.id.ic_shipping -> setCurrentFragment(frShipmentpage)
                R.id.ic_cart -> setCurrentFragment(frCartpage)
                R.id.ic_profile -> setCurrentFragment(frProfilepage)
            }
            true
        }

    }
    fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}