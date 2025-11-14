package com.bignerdranch.android.pr22_karamov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColor
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

        var currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null)
        {
            val loginFragment = Login()

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .addToBackStack("Login")
                .commit()

            cabinetButton.setOnClickListener {
                currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
                when (currentFragment)
                {
                    is Login ->
                    {
                        Toast.makeText(this, "Сначала нужно войти", Toast.LENGTH_SHORT).show()
                    }
                    else ->
                    {
                        val cabinetFragment = Cabinet()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, cabinetFragment)
                            .addToBackStack("Cabinet")
                            .commit()
                    }
                }
            }

            moviesButton.setOnClickListener {
                currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
                when (currentFragment)
                {
                    is Login ->
                    {
                        Toast.makeText(this, "Сначала нужно войти", Toast.LENGTH_SHORT).show()
                    }
                    else ->
                        {
                        val moviesFragment = Movies()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, moviesFragment)
                            .addToBackStack("Movies")
                            .commit()
                    }
                }
            }
            logoutButton.setOnClickListener {
                currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
                when (currentFragment)
                {
                    is Login ->
                    {
                        Toast.makeText(this, "Сначала нужно войти", Toast.LENGTH_SHORT).show()
                    }
                    else ->
                        {
                            val loginFragment = Login()
                            supportFragmentManager
                                .beginTransaction()
                                .replace(R.id.fragment_container, loginFragment)
                                .addToBackStack("Login")
                                .commit()
                    }
                }
            }
        }
    }
}