package com.theapphideaway.skyscraperflights.Adapters

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.theapphideaway.skyscraperflights.Activities.WebFlightActivity
import com.theapphideaway.skyscraperflights.Model.FlightResponse
import com.theapphideaway.skyscraperflights.Model.Quote
import com.theapphideaway.skyscraperflights.R

class FlightAdapter(private val flightResponse: FlightResponse, private val context: Context):
    RecyclerView.Adapter<FlightAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {

        var noteCard = LayoutInflater.from(context).inflate(R.layout.quote_list_item, viewGroup, false)

        return ViewHolder(noteCard)
    }

    override fun getItemCount(): Int {
        return flightResponse.Quotes.count()
    }

    fun goToFlight(url: String){
        var intent = Intent(context, WebFlightActivity::class.java)
        intent.putExtra("Url", url)
        startActivity(context, intent, null)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(flightResponse.Quotes[position], position)

        holder.itemView.setOnClickListener { goToFlight(flightResponse.Quotes[position].QuoteDateTime) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(flight: Quote, position: Int) {

            var costText: TextView = itemView.findViewById(R.id.cost_text_view) as TextView
            var timeTextView: TextView = itemView.findViewById(R.id.time_text_view) as TextView


            costText.text = flight.MinPrice.toString()
            timeTextView.text = flight.OutboundLeg.DepartureDate + " " + flight.InboundLeg.DepartureDate


        }

    }
}