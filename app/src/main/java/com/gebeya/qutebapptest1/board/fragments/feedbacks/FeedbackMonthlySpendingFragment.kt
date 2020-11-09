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
import kotlinx.android.synthetic.main.fragment_feedback_monthly_spending_fragment.*
import lecho.lib.hellocharts.model.*


class FeedbackMonthlySpendingFragment : Fragment() {

    var axisData = arrayOf(
        "0:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "Aug", "Sept",
        "Oct", "Nov", "Dec"
    )
    var graphSpendingAmount: ArrayList<Int> = arrayListOf()

    var yAxisData = intArrayOf(50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18)

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
        FeedbackData.setupMonthlyData()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val totalMonthlyTransaction= FeedbackData.monthlySpendingData
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

    private fun initGraph(){

        //put the data of the spending amounts into the arraylist
        FinancialData.spendingData.forEach {
            graphSpendingAmount.add(it.spendingAmount.toInt())
        }
        //convert to an int array
        yAxisData= graphSpendingAmount.toIntArray()

        val yAxisValues: MutableList<PointValue> = ArrayList()
        val axisValues: MutableList<AxisValue> = mutableListOf()

        val line: Line = Line(yAxisValues)
            .setColor(Color.parseColor("#9C27B0"))

        for (i in 0 until axisData.size) {
            axisValues.add(i, AxisValue(i.toFloat()).setLabel(axisData[i]))
        }


        for (i in 0 until yAxisData.size) {
            yAxisValues.add(PointValue(i.toFloat(), yAxisData[i].toFloat()))
        }

//        try{
//            for(i in 0 until FinancialData.spendingData.size){
//                yAxisValues.add(PointValue(i.toFloat(), FinancialData.spendingData[i].spendingAmount.toFloat()))
//            }
//        }catch (e: Exception){
//            Log.d("GraphException", e.toString())
//        }

        val lines: MutableList<Line> = arrayListOf()
        lines.add(line)

        val data = LineChartData()
        data.setLines(lines)

        val axis = Axis()
        axis.values = axisValues
        axis.textSize = 16
        axis.textColor = Color.parseColor("#03A9F4")
        data.axisXBottom = axis

        val yAxis = Axis()
        yAxis.name = "Transaction"
        yAxis.textColor = Color.parseColor("#03A9F4")
        yAxis.textSize = 16
        data.axisYLeft = yAxis

        lineChartView.lineChartData = data
        val viewport = Viewport(lineChartView.maximumViewport)
        viewport.top = 110f
        lineChartView.maximumViewport = viewport
        lineChartView.currentViewport = viewport
    }

}