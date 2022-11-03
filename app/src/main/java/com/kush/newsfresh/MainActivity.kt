package com.kush.newsfresh


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.kush.newsfresh.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), Selectlistner {

    //implementing view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //layoutManager which explains how the items are displayed
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val items = fetchdata()
        val adapter = NewsListAdapter(items,this)
        binding.recyclerview.adapter = adapter


    }
    private fun fetchdata() {
        val url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=6a15849650844d5b83d7d354a7abc2fd"

        val jsonObjectRequest = JsonObjectRequest(
           Request.Method.GET,url,
           null,
            Response.Listener {

            }
           ,
            Response.ErrorListener {

            }

       )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }

    override fun onItemClicked(item: String) {
       Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
    }
}