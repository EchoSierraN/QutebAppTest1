package com.gebeya.qutebapptest1.board.fragments.entryCategories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.adapters.DashIncomeAdapter
import com.gebeya.qutebapptest1.board.fragments.entryCategories.adapters.IncomeCategoryAdapter
import com.gebeya.qutebapptest1.board.fragments.entryCategories.adapters.SpendingCategoryAdapter
import com.gebeya.qutebapptest1.data.FinancialData
import kotlinx.android.synthetic.main.activity_income_category.*
import kotlinx.android.synthetic.main.fragment_dashboard_income.*
import kotlinx.android.synthetic.main.layout_dashboard_summary.*

class IncomeCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income_category)

        val incomeCategoryAdapter =
            IncomeCategoryAdapter(FinancialData.incomeCategoryData, this)

        rl_categories_income.layoutManager = LinearLayoutManager(this)
        rl_categories_income.adapter = incomeCategoryAdapter

    }

}