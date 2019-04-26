package com.theapphideaway.skyscraperflights.Model

import java.io.Serializable

data class OutboundLeg(
    var CarrierIds: List<Int>,
    var DepartureDate: String,
    var DestinationId: Int,
    var OriginId: Int
): Serializable