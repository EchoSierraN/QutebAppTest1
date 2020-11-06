package com.gebeya.qutebapptest1.board.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.adapters.DashSpendingAdapter
import com.gebeya.qutebapptest1.board.fragments.entryCategories.SpendingCategoryActivity
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.login.DASHBOARD_NAME
import kotlinx.android.synthetic.main.fragment_dashboard_spending.*
import kotlinx.android.synthetic.main.layout_dashboard_summary.*


class DashboardSpendingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(this::class.java.simpleName, "OnCreate called.")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //apply data received from bundle
        //From SignIn and SignUp
//        val DashboardName= arguments!!.getString(DASHBOARD_NAME)
//        tv_dashboard_title.text= DashboardName


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_spending, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //customize imported views for this fragment
        cash_flow_type.text= getString(R.string.spending_cash_flow_type)

        val dashSpendingAdapter= DashSpendingAdapter(FinancialData.spendingData, this.context!!)
        rv_spending_transactions.layoutManager= LinearLayoutManager(this.context)
        rv_spending_transactions.adapter= dashSpendingAdapter

        btn_spending_add.setOnClickListener {
            startActivity(Intent(context, SpendingCategoryActivity::class.java))
        }
    }

}