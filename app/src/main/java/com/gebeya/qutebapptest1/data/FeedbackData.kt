package com.gebeya.qutebapptest1.data

import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.model.FeedbackSpendingModel

object FeedbackData {
    var monthlySpendingData = arrayListOf(
        FeedbackSpendingModel(R.drawable.arrow_down, "January 2020", "20% from December"),
        FeedbackSpendingModel(R.drawable.arrow_up, "February 2020", "10% from January"),
        FeedbackSpendingModel(R.drawable.arrow_down, "March 2020", "50% from February"),
        FeedbackSpendingModel(R.drawable.arrow_up, "April 2020", "20% from March")
    )

}