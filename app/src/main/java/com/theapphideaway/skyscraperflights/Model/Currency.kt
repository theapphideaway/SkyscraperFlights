package com.theapphideaway.skyscraperflights.Model

import java.io.Serializable

data class Currency(
    var Code: String,
    var DecimalDigits: Int,
    var DecimalSeparator: String,
    var RoundingCoefficient: Int,
    var SpaceBetweenAmountAndSymbol: Boolean,
    var Symbol: String,
    var SymbolOnLeft: Boolean,
    var ThousandsSeparator: String
): Serializable