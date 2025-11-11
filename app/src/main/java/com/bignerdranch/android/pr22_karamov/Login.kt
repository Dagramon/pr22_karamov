package com.bignerdranch.android.pr22_karamov

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.graphics.drawable.toDrawable
import com.google.android.material.snackbar.Snackbar

class Login : Fragment() {

    lateinit var loginEditText : EditText
    lateinit var passwordEditText : EditText
    lateinit var buttonEnter : Button
    lateinit var rememberCheck : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        loginEditText = view.findViewById(R.id.login)
        passwordEditText = view.findViewById(R.id.password)
        buttonEnter = view.findViewById(R.id.buttonEnter)
        rememberCheck = view.findViewById(R.id.checkbox)

        buttonEnter.setOnClickListener {
            if (loginEditText.text.toString() != "" && passwordEditText.text.toString() != "")
            {
                if (loginEditText.text.toString() == "ects" && passwordEditText.text.toString() == "ects2025")
                {
                    val movies = Movies()
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, movies)
                        .commit()
                }
                else
                {
                    Snackbar.make(
                        view,
                        "Неверный логин или пароль",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
            else
            {
                Snackbar.make(
                    view,
                    "Поля логин и пароль должны быть заполнены",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            Login().apply {

            }
    }
}