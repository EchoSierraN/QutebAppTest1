package com.gebeya.qutebapptest1.data

import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.model.*
import java.util.*
import kotlin.collections.ArrayList

object FinancialData {
    var incomeData: ArrayList<IncomeModel> = arrayListOf(
        IncomeModel(incomeCategories.DAY_JOB,"Web design", 15000f, Date(2020, 10, 2)),
        IncomeModel(incomeCategories.DIGITAL_ASSET_SALES,"Digital asset sales", 2000f, Date(2020, 10, 2))
    )
    var spendingData: ArrayList<SpendingModel> = arrayListOf(
        SpendingModel(spendingCategories.ENTERTAINMENT,"Movies", 250f, Date(2020, 10, 26)),
        SpendingModel(spendingCategories.FAMILY_AND_PERSONAL,"Transportation", 300f, Date(2020, 10, 26))
    )

    var incomeCategoryData: ArrayList<IncomeDataModel> = arrayListOf(
        IncomeDataModel(R.drawable.ic_baseline_work_24, "Day Job", 0),
        IncomeDataModel(R.drawable.ic_baseline_computer_24, "Digital Asset Sales", 0),
        IncomeDataModel(R.drawable.ic_baseline_video_library_24, "Content Creation", 0)
    )

    var spendingCategoryData: ArrayList<SpendingDataModel> = arrayListOf(
        SpendingDataModel(R.drawable.ic_baseline_account_circle_24, "Family and Personal", 0),
        SpendingDataModel(R.drawable.ic_baseline_games_24, "Entertainment", 0),
        SpendingDataModel(R.drawable.ic_baseline_fastfood_24, "Food", 0)
    )
}