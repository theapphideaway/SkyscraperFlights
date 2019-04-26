package com.theapphideaway.skyscraperflights.Model

import java.io.Serializable

data class Quote(
    var Direct: Boolean,
    var InboundLeg: InboundLeg,
    var MinPrice: Int,
    var OutboundLeg: OutboundLeg,
    var QuoteDateTime: String,
    var QuoteId: Int
): Serializable