package com.gebeya.qutebapptest1.data

import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.model.*
import java.util.*
import kotlin.collections.ArrayList

object FinancialData {
    var incomeData: ArrayList<IncomeModel> = arrayListOf(
        IncomeModel(IncomeCategories.DAY_JOB,"Web design", 15000.0, Date(2020, 10, 2).toString()),
        IncomeModel(IncomeCategories.DIGITAL_ASSET_SALES,"Digital asset sales", 2000.0, Date(2020, 10, 2).toString())
    )
    var spendingData: ArrayList<SpendingModel> = arrayListOf(
        SpendingModel(SpendingCategories.ENTERTAINMENT,"Movies", 250.0, Date(2020, 10, 26).toString()),
        SpendingModel(SpendingCategories.FAMILY_AND_PERSONAL,"Transportation", 300.0, Date(2020, 10, 26).toString())
    )

    var incomeCategoryData: ArrayList<IncomeDataModel> = arrayListOf(
        IncomeDataModel(R.drawable.ic_baseline_work_24, "Day Job", 0),
        IncomeDataModel(R.drawable.ic_baseline_computer_24, "Digital Asset Sales", 0),
        IncomeDataModel(R.drawable.ic_baseline_video_library_24, "Content Creation", 0)
    )

    var spendingCategoryData: ArrayList<SpendingDataModel> = arrayListOf(
        SpendingDataModel(R.drawable.ic_baseline_account_circle_24, "Family and Personal", 0),  /*id=0*/
        SpendingDataModel(R.drawable.ic_baseline_games_24, "Entertainment", 0), /*id=1*/
        SpendingDataModel(R.drawable.ic_baseline_fastfood_24, "Food", 0)    /*id=2*/
    )
}