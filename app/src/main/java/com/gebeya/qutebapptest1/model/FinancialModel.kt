package com.gebeya.qutebapptest1.model

import java.util.*

data class IncomeModel(
    var incomeCategory: incomeCategories = incomeCategories.DAY_JOB,
    var incomeSource: String = "DefaultIncome",
    var incomeAmount: Float = 0.0f,
    var incomeDate: Date = Date(2020, 8, 23)
)

data class SpendingModel(
    var spendingCategory: spendingCategories = spendingCategories.FAMILY_AND_PERSONAL,
    var spendingSource: String,
    var spendingAmount: Float,
    var spendingDate: Date = Date(2020, 8, 23)
)

enum class spendingCategories {
    ENTERTAINMENT, FAMILY_AND_PERSONAL, FOOD
}

enum class incomeCategories {
    DAY_JOB, DIGITAL_ASSET_SALES, CONTENT_CREATION
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