package com.gebeya.qutebapptest1.board.fragments.feedbacks

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.data.FeedbackData
import com.gebeya.qutebapptest1.data.FinancialData
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import kotlinx.android.synthetic.main.fragment_feedback_monthly_spending_fragment.*


class FeedbackMonthlySpendingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_feedback_monthly_spending_fragment,
            container,
            false
        )
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        FeedbackData.setupMonthlyData()
        val totalMonthlyTransaction = FeedbackData.monthlySpendingData
        totalMonthlyTransaction.addAll(FeedbackData.monthlyIncomeData)
        //replaced with totalMonthlyTransaction
//        val feedMonthSpendingAdapter =
//            FeedMonthSpendingAdapter(FeedbackData.monthlySpendingData, this.context!!)

        val feedMonthSpendingAdapter =
            FeedMonthSpendingAdapter(totalMonthlyTransaction, this.context!!)

        rv_feedback_monthly.layoutManager = LinearLayoutManager(this.context)
        rv_feedback_monthly.adapter = feedMonthSpendingAdapter


        initGraph()
    }

    private fun initGraph() {

        //prepare spending data
        var spendingDataArrayList: ArrayList<Double> = arrayListOf()
        FinancialData.spendingData.forEach {
            spendingDataArrayList.add(it.spendingAmount)
        }
        var spendingData: Array<Any> = spendingDataArrayList.toTypedArray()

        //prepare spending data
        var incomeDataArrayList: ArrayList<Double> = arrayListOf()
        FinancialData.incomeData.forEach {
            incomeDataArrayList.add(it.incomeAmount)
        }
        var incomeData: Array<Any> = incomeDataArrayList.toTypedArray()

        val aaChartModel: AAChartModel = AAChartModel()
            .chartType(AAChartType.Line)
            .title("Summary")
            .subtitle("Recorded Spending and Income")
            .backgroundColor("#80CCEF")
            .dataLabelsEnabled(true)
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("Spending")
                        .data(spendingData),
                    AASeriesElement()
                        .name("Income")
                        .data(incomeData)
                )
            )
        //The chart view object calls the instance object of AAChartModel and draws the final graphic
        aa_chart_view.aa_drawChartWithChartModel(aaChartModel)
    }

    //region EXAMPLE CODE
//    private fun initGraph(){
//        val aaChartModel : AAChartModel = AAChartModel()
//            .chartType(AAChartType.Line)
//            .title("title")
//            .subtitle("subtitle")
//            .backgroundColor("#2fb9f8")
//            .dataLabelsEnabled(true)
//            .series(arrayOf(
//                AASeriesElement()
//                    .name("Tokyo")
//                    .data(arrayOf(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6)),
////                AASeriesElement()
////                    .name("NewYork")
////                    .data(arrayOf(0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5)),
////                AASeriesElement()
////                    .name("London")
////                    .data(arrayOf(0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0)),
//                AASeriesElement()
//                    .name("Berlin")
//                    .data(arrayOf(3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8))
//            )
//            )
//
//        //The chart view object calls the instance object of AAChartModel and draws the final graphic
//        aa_chart_view.aa_drawChartWithChartModel(aaChartModel)
//    }
    //endregion

}