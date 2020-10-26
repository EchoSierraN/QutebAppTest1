package com.gebeya.qutebapptest1.data

import com.gebeya.qutebapptest1.model.IncomeModel
import com.gebeya.qutebapptest1.model.SpendingModel
import java.util.*
import kotlin.collections.ArrayList

object FinancialData{
    var incomeData: ArrayList<IncomeModel> = arrayListOf()
    var spendingData: ArrayList<SpendingModel> = arrayListOf(
        SpendingModel("Movies", 250f, Date(2020, 10, 26)),
        SpendingModel("Transportation", 300f, Date(2020, 10, 26))
    )
}