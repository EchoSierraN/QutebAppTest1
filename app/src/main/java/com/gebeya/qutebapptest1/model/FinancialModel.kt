package com.gebeya.qutebapptest1.model

import java.time.LocalDate
import java.util.*

data class IncomeModel(
    var incomeCategory: incomeCategories = incomeCategories.DAY_JOB,
    var incomeSource: String = "DefaultIncome",
    var incomeAmount: Double = 0.0,
    var incomeDate: String = Date().toString()
)

data class SpendingModel(
    var spendingCategory: spendingCategories = spendingCategories.FAMILY_AND_PERSONAL,
    var spendingSource: String,
    var spendingAmount: Double,
    var spendingDate: String= Date().toString()
)

enum class spendingCategories {
    ENTERTAINMENT, FAMILY_AND_PERSONAL, FOOD
}

enum class incomeCategories {
    DAY_JOB,    /*id=0*/
    DIGITAL_ASSET_SALES,    /*id=1*/
    CONTENT_CREATION    /*id=2*/
}

data class SpendingDataModel(
    var categoryImage: Int,
    var categoryName: String = "Spending",
    var spendingCount: Int = 0
)
data class IncomeDataModel(
    var categoryImage: Int,
    var categoryName: String = "Spending",
    var incomeCount: Int = 0
)