package com.gebeya.qutebapptest1.model

import java.util.*

data class IncomeModel(
    var incomeCategory: IncomeCategories = IncomeCategories.DAY_JOB,
    var incomeSource: String = "DefaultIncome",
    var incomeAmount: Double = 0.0,
    var incomeDate: Date = Date()
)

data class SpendingModel(
    var spendingCategory: SpendingCategories = SpendingCategories.FAMILY_AND_PERSONAL,
    var spendingSource: String,
    var spendingAmount: Double,
    var spendingDate: Date= Date()
)

enum class SpendingCategories {
    ENTERTAINMENT, FAMILY_AND_PERSONAL, FOOD
}

enum class IncomeCategories {
    DAY_JOB,
    DIGITAL_ASSET_SALES,
    CONTENT_CREATION
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