package com.gebeya.qutebapptest1.model

import com.gebeya.qutebapptest1.R

data class FeedbackTransactionModelModel (
    var image: Int= R.drawable.arrow_down,
    var month: String= "January, 2020",
    var summary: String= "Spending",
    var amount: Double= 0.0
)
