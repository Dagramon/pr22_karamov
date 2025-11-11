package com.bignerdranch.android.pr22_karamov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var cabinetButton : Button
    lateinit var moviesButton : Button
    lateinit var logoutButton : Button
    lateinit var bottomBar : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cabinetButton = findViewById(R.id.cabinetButton)
        moviesButton = findViewById(R.id.moviesButton)
        logoutButton = findViewById(R.id.logoutButton)
        bottomBar = findViewById(R.id.bottomNav)

        //bottomBar.background = R.color.gray.toDrawable()
        cabinetButton.setOnClickListener {}
        moviesButton.setOnClickListener {}
        logoutButton.setOnClickListener {}

        var currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null)
        {
            val loginFragment = Login()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, loginFragment)
                .commit()

            cabinetButton.setOnClickListener {
                Toast.makeText(this, currentFragment.toString(), Toast.LENGTH_LONG).show()
                val cabinetFragment = Cabinet()
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, cabinetFragment)
                    .commit()
            }

            moviesButton.setOnClickListener {
                val moviesFragment = Movies()
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, moviesFragment)
                    .commit()
            }
            logoutButton.setOnClickListener {
                val loginFragment = Login()

                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, loginFragment)
                    .commit()
            }
        }
    }
}