package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.MoonAdapter
import com.example.myapplication.databinding.ActivityHomeoutput22Binding

class Homeoutput22Activity : AppCompatActivity() {
    //binding
    private lateinit var bind: ActivityHomeoutput22Binding

    //data list for recyclerview
    private val imageList1 = arrayListOf(R.drawable.sky, R.drawable.moon, R.drawable.sea)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homeoutput22)


// initialize view binding
        bind = ActivityHomeoutput22Binding.inflate(layoutInflater)
        setContentView(bind.root)


// handle system insets for edge to edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // display user data from intent
        displayUserData()
        // Setup RecyclerView
        setupRecyclerView()
    }

    private fun displayUserData() {
        // Get the data from the Intent
        val fullName = intent.getStringExtra("FULL NAME") ?: "N/A"
        val email = intent.getStringExtra("EMAIL") ?: "N/A"
        val gender = intent.getStringExtra("GENDER") ?: "N/A"
        val country = intent.getStringExtra("COUNTRY") ?: "N/A"
        val city = intent.getStringExtra("CITY") ?: "N/A"

        // Display the data in the UI


        bind.outputwelcome.text = "Full Name: $fullName"
        bind.outputemail.text = "Email: $email"
        bind.outputgender.text = "Gender: $gender"
        bind.outputcountry.text = "Country: $country"
        bind.outputcity.text = "City: $city"
    }

    private fun setupRecyclerView() {
        // RecyclerView Adapter
        val adapter = MoonAdapter(this, imageList1)

        // Setup RecyclerView with GridLayoutManager
        bind.recyclevieww.adapter = adapter
        bind.recyclevieww.layoutManager = GridLayoutManager(this, 1)
    }
}
