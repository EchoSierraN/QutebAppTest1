package com.gebeya.qutebapptest1.data

import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.model.FeedbackTransactionModelModel

object FeedbackData {
    var monthlySpendingData: ArrayList<FeedbackTransactionModelModel> = arrayListOf(
//        FeedbackSpendingModel(R.drawable.arrow_down, "January 2020", "20% from December"),
//        FeedbackSpendingModel(R.drawable.arrow_up, "February 2020", "10% from January"),
//        FeedbackSpendingModel(R.drawable.arrow_down, "March 2020", "50% from February"),
//        FeedbackSpendingModel(R.drawable.arrow_up, "April 2020", "20% from March")
    )

    var monthlyIncomeData: ArrayList<FeedbackTransactionModelModel> = arrayListOf()

    fun setupMonthlyData() {
        FinancialData.spendingData.forEach {
            monthlySpendingData.add(
                FeedbackTransactionModelModel(
                    R.drawable.arrow_down,
        //passing the actual date instead of the month so it won't be confusing
                    it.spendingDate.toString(),
                    "Spending",
                    it.spendingAmount
                )
            )
        }

        FinancialData.incomeData.forEach {
            monthlyIncomeData.add(
                FeedbackTransactionModelModel(
        //passing the actual date instead of the month so it won't be confusing
                    R.drawable.arrow_up, it.incomeDate.toString(), "Income", it.incomeAmount
                )
            )
        }
    }

}