package com.gebeya.qutebapptest1.board.fragments.entryCategories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.fragments.entryCategories.adapters.IncomeCategoryAdapter
import com.gebeya.qutebapptest1.board.fragments.entryCategories.adapters.SpendingCategoryAdapter
import com.gebeya.qutebapptest1.data.FinancialData
import kotlinx.android.synthetic.main.activity_income_category.*

class SpendingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spending_category)

        val spendingCategoryAdapter =
            SpendingCategoryAdapter(FinancialData.spendingCategoryData, this)

        val a= findViewById(R.id.rl_categories_spending) as RecyclerView
        a.layoutManager = LinearLayoutManager(this)
        a.adapter = spendingCategoryAdapter

        rl_categories_income.layoutManager = LinearLayoutManager(this)
        rl_categories_income.adapter = spendingCategoryAdapter

    }

}