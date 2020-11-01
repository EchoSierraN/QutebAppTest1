package com.gebeya.qutebapptest1.board.fragments.feedbacks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.data.FeedbackData
import kotlinx.android.synthetic.main.fragment_feedback_monthly_spending_fragment.*

class FeedbackMonthlySpendingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback_monthly_spending_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val feedMonthSpendingAdapter =
            FeedMonthSpendingAdapter(FeedbackData.monthlySpendingData, this.context!!)

        rv_feedback_monthly.layoutManager = LinearLayoutManager(this.context)
        rv_feedback_monthly.adapter = feedMonthSpendingAdapter
    }

}