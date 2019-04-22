package com.theapphideaway.skyscraperflights.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.theapphideaway.skyscraperflights.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_button.setOnClickListener {
            var intent = Intent(this, FlightListActivity::class.java)
            startActivity(intent)
        }
    }
}
