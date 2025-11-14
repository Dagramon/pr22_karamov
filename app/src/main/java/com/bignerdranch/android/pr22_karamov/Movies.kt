package com.bignerdranch.android.pr22_karamov

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.toolbox.StringRequest
import com.android.volley.RequestQueue
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import org.json.JSONObject

class Movies : Fragment() {
    val baseurl = "https://api.poiskkino.dev/v1.4/movie?page=1&limit=10&selectFields=name&genres.name=криминал"
    val apiKey = "AA4XYG3-A604X3G-KJMABXX-2G6FSQ1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            Movies().apply {
            }
    }
    fun GetResult()
    {
        val queue = Volley.newRequestQueue(this.requireContext())
        val stringRequest = StringRequest(
            Request.Method.GET,
            baseurl,
            {
                    response->
                val obj = JSONObject(response)
            },
            {
                Log.d("MyLog", "Volley error")
            }
        )
        queue.add(stringRequest)
    }
}