package com.theapphideaway.skyscraperflights.Model

import android.os.Parcelable
import java.io.Serializable

data class FlightResponse(
    var Carriers: List<Carrier>,
    var Currencies: List<Currency>,
    var Places: List<Place>,
    var Quotes: List<Quote>
): Serializable