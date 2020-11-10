package com.gebeya.qutebapptest1.board.fragments

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.adapters.DashIncomeAdapter
import com.gebeya.qutebapptest1.board.adapters.DashSpendingAdapter
import com.gebeya.qutebapptest1.board.fragments.entryCategories.IncomeCategoryActivity
import com.gebeya.qutebapptest1.board.fragments.entryCategories.SpendingCategoryActivity
import com.gebeya.qutebapptest1.data.FinancialData
import kotlinx.android.synthetic.main.fragment_dashboard_income.*
import kotlinx.android.synthetic.main.fragment_dashboard_spending.*
import kotlinx.android.synthetic.main.layout_dashboard_summary.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class DashboardIncomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_income, container, false)
    }

    override fun onResume() {
        super.onResume()
        var totalIncome: Double= 0.0
        FinancialData.incomeData.forEach {
            totalIncome+= it.incomeAmount
        }
        tv_total_transaction.text= DashboardSpendingFragment.formatMoney(totalIncome)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //customize imported views for this fragment
        cash_flow_type.text= getString(R.string.income_cash_flow_type)

        val dashIncomeAdapter= DashIncomeAdapter(FinancialData.incomeData, this.context!!)
        rv_income_transactions.layoutManager= LinearLayoutManager(this.context)
        rv_income_transactions.adapter= dashIncomeAdapter

        btn_income_add.setOnClickListener {
            startActivity(Intent(context, IncomeCategoryActivity::class.java))
        }
    }

}