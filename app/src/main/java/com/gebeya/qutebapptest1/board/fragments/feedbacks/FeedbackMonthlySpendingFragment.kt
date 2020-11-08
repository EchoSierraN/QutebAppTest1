package com.gebeya.qutebapptest1.board.fragments.feedbacks

import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
        "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
        "Oct", "Nov", "Dec"
    )
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val feedMonthSpendingAdapter =
            FeedMonthSpendingAdapter(FeedbackData.monthlySpendingData, this.context!!)

        rv_feedback_monthly.layoutManager = LinearLayoutManager(this.context)
        rv_feedback_monthly.adapter = feedMonthSpendingAdapter

        initGraph()
    }

//    private fun initGraph() {
//        val values: MutableList<PointValue> = ArrayList()
//        values.add(PointValue(0f, 2f))
//        values.add(PointValue(1f, 4f))
//        values.add(PointValue(2f, 3f))
//        values.add(PointValue(3f, 4f))
        //get data from app

        //region GET MONTHLY SPENDINGS

//        var spendingsJan: List<Double> = listOf()
//        var spendingsFeb: List<Double> = listOf()
//        var spendingsMar: List<Double> = listOf()
//        var spendingsApr: List<Double> = listOf()
//        var spendingsMay: List<Double> = listOf()
//        var spendingsJun: List<Double> = listOf()
//        var spendingsJul: List<Double> = listOf()
//        var spendingsAug: List<Double> = listOf()
//        var spendingsSep: List<Double> = listOf()
//        var spendingsOct: List<Double> = listOf()
//        var spendingsNov: List<Double> = listOf()
//        var spendingsDec: List<Double> = listOf()
//        spendingsJan= FinancialData.spendingData.filter { it.spendingDate.month== 1 }.map { it.spendingAmount }
//        spendingsFeb= FinancialData.spendingData.filter { it.spendingDate.month== 2 }.map { it.spendingAmount }
//        spendingsMar= FinancialData.spendingData.filter { it.spendingDate.month== 3 }
//        spendingsApr= FinancialData.spendingData.filter { it.spendingDate.month== 4 }
//        spendingsMay= FinancialData.spendingData.filter { it.spendingDate.month== 5 }
//        spendingsJun= FinancialData.spendingData.filter { it.spendingDate.month== 6 }
//        spendingsJul= FinancialData.spendingData.filter { it.spendingDate.month== 7 }
//        spendingsAug= FinancialData.spendingData.filter { it.spendingDate.month== 8 }
//        spendingsSep= FinancialData.spendingData.filter { it.spendingDate.month== 9 }
//        spendingsOct= FinancialData.spendingData.filter { it.spendingDate.month== 10 }
//        spendingsNov= FinancialData.spendingData.filter { it.spendingDate.month== 11 }
//        spendingsDec= FinancialData.spendingData.filter { it.spendingDate.month== 12 }
        //endregion

        //region GET SUM OF SPENDINGS FOR EACH MONTH
//        var spendingsSumJan= 0f
//        for (i in 0..spendingsJan.size){
//            spendingsSumJan+= spendingsJan[i].spendingAmount.toFloat()
//        }
//        var spendingsSumFeb= 0f
//        for (i in 0..spendingsFeb.size){
//            spendingsSumFeb+= spendingsFeb[i].spendingAmount.toFloat()
//        }
//        var spendingsSumMar= 0f
//        for (i in 0..spendingsMar.size){
//            spendingsSumMar+= spendingsMar[i].spendingAmount.toFloat()
//        }
//        var spendingsSumMay= 0f
//        for (i in 0..spendingsMay.size){
//            spendingsSumMay+= spendingsMay[i].spendingAmount.toFloat()
//        }
//        var spendingsSumJun= 0f
//        for (i in 0..spendingsJun.size){
//            spendingsSumJun+= spendingsJun[i].spendingAmount.toFloat()
//        }
//        var spendingsSumJul= 0f
//        for (i in 0..spendingsJul.size){
//            spendingsSumJul+= spendingsJul[i].spendingAmount.toFloat()
//        }
//        var spendingsSumAug= 0f
//        for (i in 0..spendingsAug.size){
//            spendingsSumAug+= spendingsAug[i].spendingAmount.toFloat()
//        }
//        var spendingsSumSep= 0f
//        for (i in 0..spendingsSep.size){
//            spendingsSumSep+= spendingsSep[i].spendingAmount.toFloat()
//        }
//        var spendingsSumOct= 0f
//        for (i in 0..spendingsOct.size){
//            spendingsSumOct+= spendingsOct[i].spendingAmount.toFloat()
//        }
//        var spendingsSumNov= 0f
//        for (i in 0..spendingsNov.size){
//            spendingsSumNov+= spendingsNov[i].spendingAmount.toFloat()
//        }
//        var spendingsSumDec= 0f
//        for (i in 0..spendingsDec.size){
//            spendingsSumDec+= spendingsDec[i].spendingAmount.toFloat()
//        }
//        var spendingsSumApr= 0f
//        for (i in 0..spendingsApr.size){
//            spendingsSumApr+= spendingsApr[i].spendingAmount.toFloat()
//        }

        //endregion

        //region MAKE POINTS WITH THE SUM VALUES
//        var values: MutableList<PointValue> = ArrayList()
//        values.add(PointValue(1f, spendingsSumJan))
//        values.add(PointValue(2f, spendingsSumFeb))
//        values.add(PointValue(3f, spendingsSumMar))
//        values.add(PointValue(4f, spendingsSumApr))
//        values.add(PointValue(5f, spendingsSumMay))
//        values.add(PointValue(6f, spendingsSumJun))
//        values.add(PointValue(7f, spendingsSumJul))
//        values.add(PointValue(8f, spendingsSumAug))
//        values.add(PointValue(9f, spendingsSumSep))
//        values.add(PointValue(10f, spendingsSumOct))
//        values.add(PointValue(11f, spendingsSumNov))
//        values.add(PointValue(12f, spendingsSumDec))
        //endregion
        //In most cased you can call data model methods in builder-pattern-like manner.

        //In most cased you can call data model methods in builder-pattern-like manner.
//        val line =
//            Line(values).setColor(Color.BLUE).setCubic(true)
//        val lines: MutableList<Line> =
//            ArrayList()
//        lines.add(line)
//
//        val data = LineChartData()
//        data.lines = lines
//
//        val chart = LineChartView(context)
//        chart.lineChartData = data
//    }

    private fun initGraph(){

        val yAxisValues: MutableList<PointValue> = ArrayList()
        val axisValues: MutableList<AxisValue> = mutableListOf()

        val line: Line = Line(yAxisValues)
            .setColor(Color.parseColor("#9C27B0"))

//        for (i in 0 until axisData.size) {
//            axisValues.add(i, AxisValue(i.toFloat()).setLabel(axisData[i]))
//        }

        for(i in 0 until axisData.size){
            axisValues.add(i, AxisValue(i.toFloat()).setLabel(axisData[i]))
        }

//        for (i in 0 until yAxisData.size) {
//            yAxisValues.add(PointValue(i.toFloat(), yAxisData[i].toFloat()))
//        }

        try{
            for(i in 0 until FinancialData.spendingData.size){
                yAxisValues.add(PointValue(i.toFloat(), FinancialData.spendingData[i].spendingAmount.toFloat()))
            }
        }catch (e: Exception){
            Log.d("GraphException", e.toString())
        }

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