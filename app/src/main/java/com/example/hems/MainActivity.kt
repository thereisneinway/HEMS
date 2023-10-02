package com.example.hems

import java.io.*
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import android.view.MenuItem


class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(Home_Fragment())
        bottomNav = findViewById(R.id.bottonnav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Home -> {
                    loadFragment(Home_Fragment())
                    true
                }
                R.id.Planner -> {
                    loadFragment(Planner_Fragment())
                    true
                }
                R.id.profile -> {
                    loadFragment(Profile_Fragment())
                    true
                }

                else -> {true}
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.relativelayout,fragment)
        transaction.commit()
    }

}