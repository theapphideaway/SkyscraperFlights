package com.theapphideaway.skyscraperflights.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.theapphideaway.skyscraperflights.R
import com.theapphideaway.skyscraperflights.Services.FlightService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var searchButton: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.search_button)

        onSearchPressed()
    }

    private fun onSearchPressed(){
        searchButton.setOnClickListener {
            var flightService = FlightService()
            GlobalScope.launch {
                val response = flightService.getHeadlineApi().getSearchedHeadlines("").await()


                var intent = Intent(this@MainActivity, FlightListActivity::class.java)

                intent.putExtra("flightResponse", response)

                startActivity( intent)
            }


        }
    }
}
