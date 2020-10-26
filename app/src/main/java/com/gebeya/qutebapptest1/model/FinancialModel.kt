package com.gebeya.qutebapptest1.model

import java.util.*

data class IncomeModel(var incomeSource: String= "DefaultIncome", var incomeAmount: Float= 0.0f,  var incomeDate: Date= Date(2020, 8, 23))
data class SpendingModel(var spendingSource: String, var spendingAmount: Float,  var spendingDate: Date = Date(2020, 8, 23))

