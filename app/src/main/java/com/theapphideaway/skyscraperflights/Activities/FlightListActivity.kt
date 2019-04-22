package com.theapphideaway.skyscraperflights.Activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.theapphideaway.skyscraperflights.R

import kotlinx.android.synthetic.main.activity_flight_list.*

class FlightListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_list)
        setSupportActionBar(toolbar)

    }

}
