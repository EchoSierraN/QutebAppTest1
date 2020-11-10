package com.gebeya.qutebapptest1.data

import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.model.*
import java.util.*
import kotlin.collections.ArrayList

object FinancialData {
    var incomeData: ArrayList<IncomeModel> = arrayListOf(
        IncomeModel(IncomeCategories.DAY_JOB,"Tutoring", 1500.0, Date(2020, 11, 10)),
        IncomeModel(IncomeCategories.CONTENT_CREATION,"Youtube Tutorials", 10000.0, Date(2020, 11, 10)),
        IncomeModel(IncomeCategories.DAY_JOB,"Web design", 2500.0, Date(2020, 11, 10)),
        IncomeModel(IncomeCategories.DIGITAL_ASSET_SALES,"Digital asset sales", 2000.0, Date(2020, 11, 10))
    )
    var spendingData: ArrayList<SpendingModel> = arrayListOf(
        SpendingModel(SpendingCategories.ENTERTAINMENT,"Movies", 250.0, Date(2020, 11, 10)),
        SpendingModel(SpendingCategories.ENTERTAINMENT,"Playing Golf", 2500.0, Date(2020, 11, 10)),
        SpendingModel(SpendingCategories.ENTERTAINMENT,"Digital Games", 1250.0, Date(2020, 11, 10)),
        SpendingModel(SpendingCategories.FAMILY_AND_PERSONAL,"Transportation", 3000.0, Date(2020, 11, 10))
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