package com.gebeya.qutebapptest1.board.fragments.entryCategories

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.fragments.entryCategories.adapters.SpendingCategoryAdapter
import com.gebeya.qutebapptest1.data.FinancialData
import kotlinx.android.synthetic.main.activity_spending_category.*


class SpendingCategoryActivity : AppCompatActivity() {
    companion object{
        var currentCategoryId= 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spending_category)

        val spendingCategoryAdapter =
            SpendingCategoryAdapter(FinancialData.spendingCategoryData, this)

        rl_categories_spending.layoutManager = LinearLayoutManager(this)
        rl_categories_spending.adapter = spendingCategoryAdapter

    }

}