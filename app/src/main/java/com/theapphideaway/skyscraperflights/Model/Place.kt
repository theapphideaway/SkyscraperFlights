package com.theapphideaway.skyscraperflights.Model

import java.io.Serializable

data class Place(
    var CityId: String,
    var CityName: String,
    var CountryName: String,
    var IataCode: String,
    var Name: String,
    var PlaceId: Int,
    var SkyscannerCode: String,
    var Type: String
): Serializable