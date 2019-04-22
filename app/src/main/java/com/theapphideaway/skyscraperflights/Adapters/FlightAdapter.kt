package com.theapphideaway.skyscraperflights.Adapters

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.theapphideaway.skyscraperflights.Activities.WebFlightActivity
import com.theapphideaway.skyscraperflights.R

class FlightAdapter(private val flightResponse: FlightResponse, private val context: Context):
    RecyclerView.Adapter<FlightAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {

        var noteCard = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false)

//        val mAdView = noteCard.findViewById(R.id.ad_view) as AdView
//        val adRequest = AdRequest.Builder().build()
//        mAdView.loadAd(adRequest)

        return ViewHolder(noteCard)
    }

    override fun getItemCount(): Int {
        return flightResponse.articles.count()
    }

    fun goToArticle(url: String){
        var intent = Intent(context, WebFlightActivity::class.java)
        intent.putExtra("Url", url)
        startActivity(context, intent, null)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(flightResponse.articles[position], position)

        holder.itemView.setOnClickListener { goToArticle(flightResponse.articles[position].url) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(article: Article, position: Int) {

            var titleText: TextView = itemView.findViewById(R.id.title) as TextView
            var sourceText: TextView = itemView.findViewById(R.id.source_text_view) as TextView
            var dateText: TextView = itemView.findViewById(R.id.date_text_view) as TextView
            var newsImage = itemView.findViewById(R.id.news_image) as ImageView
            var adView = itemView.findViewById(R.id.ad_view) as AdView

            if (position % 5 != 0) {

                titleText.visibility = View.VISIBLE
                sourceText.visibility = View.VISIBLE
                dateText.visibility = View.VISIBLE
                newsImage.visibility = View.VISIBLE
                adView.visibility = View.GONE

                titleText.text = article.title
                sourceText.text = article.source.name

                val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                val date =
                    dateFormat.parse(article.publishedAt)//You will get date object relative to server/client timezone wherever it is parsed
                val formatter = SimpleDateFormat("dd MMM")
                //If you need time just put specific format for time like 'HH:mm:ss'
                val dateStr = formatter.format(date)

                dateText.text = dateStr

                Picasso.get().load(article.urlToImage).into(newsImage)
            }else{
                titleText.visibility = View.GONE
                sourceText.visibility = View.GONE
                dateText.visibility = View.GONE
                newsImage.visibility = View.GONE
                adView.visibility = View.VISIBLE
            }
        }

    }
}