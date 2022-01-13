package com.example.uniquelux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.uniquelux.home_fragment.HomeFragment
import com.example.uniquelux.notification_fragment.ChatFragment
import com.example.uniquelux.notification_fragment.PesanFragment
import kotlinx.android.synthetic.main.activity_notification_page.*

class NotificationPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_notification_page)

        val frPesanpage = PesanFragment()
        val frChatpage = ChatFragment()

        setCurrentFragment(frPesanpage)

        notification_Navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_pesan -> setCurrentFragment(frPesanpage)
                R.id.ic_chat -> setCurrentFragment(frChatpage)
            }
            true
        }
    }
    fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flNFragment, fragment)
            commit()
        }
    }
}