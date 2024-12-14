package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityButtonBinding
import com.example.myapplication.databinding.ActivityHomework1Binding

class Homework1Activity : AppCompatActivity() {


    lateinit var bind: ActivityHomework1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bind = ActivityHomework1Binding.inflate(layoutInflater)

        setContentView(R.layout.activity_homework1)
        setContentView(bind.root)

        val countries = arrayOf(
            "Nepal",
            "India",
            "Japan",
            "USA",
            "Australia",
            "China",
            "Germany",
            "United Kingdom"
        )
        //
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        bind.spinnerr.adapter = countryAdapter


        val cities = arrayOf(
            "Kathmandu", "Bhaktapur", "Lalitpur", "Kritipur",
            "Kanchanpur", "London", "Shanghai", "Berlin", "Delhi", "Sydney", "Tokyo", "New York"
        )

        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)

        bind.city.setAdapter(cityAdapter)


        bind.submit1.setOnClickListener {

            if (bind.check.isChecked) {
                //collect input and go to next activity
                val intent = Intent(this, Homeoutput22Activity::class.java).apply {
                    putExtra("FULL NAME", bind.entername.text.toString())
                    putExtra("EMAIL", bind.enteremail.text.toString())
                    putExtra("GENDER", if (bind.male.isChecked) "Male" else "Female")
                    putExtra("COUNTRY", bind.spinnerr.selectedItem.toString())
                    putExtra("CITY", bind.city.text.toString())
                }
                startActivity(intent)
            } else {
                Toast.makeText(this@Homework1Activity, "Please click on I agree", Toast.LENGTH_LONG)
                    .show()

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.genderoutput)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(
                        systemBars.left,
                        systemBars.top,
                        systemBars.right,
                        systemBars.bottom
                    )
                    insets
                }

            }

        }

    }
}


