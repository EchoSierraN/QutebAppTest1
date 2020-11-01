package com.gebeya.qutebapptest1.board.fragments.feedbacks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.data.FeedbackData
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.fragment_feedback_monthly_spending_fragment.*


class FeedbackMonthlySpendingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var barChart: BarChart

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

        //bar chart
        barChart= barChart_monthly
        drawChart(barChart)

    }

    private fun drawChart(barChart: BarChart) {

        barChart.setDrawBarShadow(false)
        barChart.setDrawValueAboveBar(true)
        barChart.setMaxVisibleValueCount(100)
        barChart.setPinchZoom(true)
        barChart.setDrawGridBackground(true)

        var barDataEntries: ArrayList<BarEntry> = arrayListOf()
        barDataEntries.add(BarEntry(1f, 80f))
        barDataEntries.add(BarEntry(2f, 78f))
        barDataEntries.add(BarEntry(3f, 66f))
        barDataEntries.add(BarEntry(4f, 90f))

        var barDataSet= BarDataSet(barDataEntries, "DataSet1")

        var data: BarData= BarData(barDataSet)
        data.barWidth= .5f

        barChart.data= data

        var months: Array<String> = arrayOf("Jan", "Feb", "Mar", "April", "May")
        var xAxis: XAxis= barChart.xAxis
        xAxis.valueFormatter= MyXAxisValueFormatter(months)

    }
    
    public class MyXAxisValueFormatter(var values: Array<String>): ValueFormatter() {
        private var mValues: Array<String> = values

        /**
         * Called when a value from an axis is to be formatted
         * before being drawn. For performance reasons, avoid excessive calculations
         * and memory allocations inside this method.
         *
         * @param value the value to be formatted
         * @param axis  the axis the value belongs to
         * @return
         *
         */
        override fun getFormattedValue(value: Float, axis: AxisBase?): String {
            return mValues[value.toInt()]
        }
    }

}