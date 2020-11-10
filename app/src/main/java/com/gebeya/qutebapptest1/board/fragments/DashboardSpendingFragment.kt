package com.gebeya.qutebapptest1.board.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.authentication.ApiClient
import com.gebeya.qutebapptest1.board.adapters.DashSpendingAdapter
import com.gebeya.qutebapptest1.board.fragments.entryCategories.SpendingCategoryActivity
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.model.*
import kotlinx.android.synthetic.main.fragment_dashboard_spending.*
import kotlinx.android.synthetic.main.layout_dashboard_summary.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


class DashboardSpendingFragment : Fragment() {

    companion object{
        fun setTotalSpendingDisplay(){
            var totalSpending: Double = 0.0
            FinancialData.spendingData.forEach {
                totalSpending += it.spendingAmount
            }
        }

        fun formatMoney(amount: Double): String{
            val moneyInt= amount.toInt()
            return StringBuilder().append(NumberFormat.getNumberInstance(Locale.US).format(moneyInt).toString()).append(" Birr").toString()
            //return "ETB ${NumberFormat.getNumberInstance(Locale.US).format(moneyInt)}"
        }
    }

    lateinit var apiClient: ApiClient

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

    override fun onResume() {
        super.onResume()
        var totalSpending: Double = 0.0
        FinancialData.spendingData.forEach {
            totalSpending += it.spendingAmount
        }
        tv_total_transaction.text= formatMoney(totalSpending)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        apiClient = ApiClient()

        //customize imported views for this fragment
        cash_flow_type.text = getString(R.string.spending_cash_flow_type)

        //Pull spending data here.
        //getAllSpendings()

        val dashSpendingAdapter = DashSpendingAdapter(FinancialData.spendingData, this.context!!)
        rv_spending_transactions.layoutManager = LinearLayoutManager(this.context)
        rv_spending_transactions.adapter = dashSpendingAdapter

        btn_spending_add.setOnClickListener {
            startActivity(Intent(context, SpendingCategoryActivity::class.java))
        }
    }

    private fun getAllSpendings() {
        apiClient.getApiService(this.context!!).getAllSpendingsRequest()
            .enqueue(object : Callback<List<SpendingResponse>> {
                /**
                 * Invoked when a network exception occurred talking to the server or when an unexpected
                 * exception occurred creating the request or processing the response.
                 */
                override fun onFailure(call: Call<List<SpendingResponse>>, t: Throwable) {

                }

                /**
                 * Invoked for a received HTTP response.
                 *
                 *
                 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                 * Call [Response.isSuccessful] to determine if the response indicates success.
                 */
                override fun onResponse(
                    call: Call<List<SpendingResponse>>,
                    response: Response<List<SpendingResponse>>
                ) {
//                    var responseSpendings = response.body()
//                    if (!responseSpendings?.isEmpty()!!) {
//                        //add data into the spending data
//                        for (i in 0 until responseSpendings.size) {
//                            FinancialData.spendingData.add(
//                                SpendingModel(
//                                    spendingCategory = enumValueOf(responseSpendings[i].spendingCategoryName),
//                                    spendingSource = "Personal expenses",
//                                    spendingAmount = responseSpendings[i].spendingAmount.toDouble(),
//                                    spendingDate =
//                                    SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(
//                                        responseSpendings[i].spendingCreationTime
//                                    )
//                                )
//                            )
//                        }
//                    }
                }

            })


    }
}


//                    if(response.body()?.allSpendings?.isNotEmpty()!!){
//                        var spendingsResponse= response.body()!!.allSpendings
//                        for(i in 0 until spendingsResponse!!.size){
//                            FinancialData.spendingData.add(
//                                SpendingModel(
//                                    spendingCategory = enumValueOf(spendingsResponse[i].spendingCategoryName),
//                                    spendingSource = "Personal Expenses",
//                                    spendingAmount = spendingsResponse[i].spendingAmount.toDouble(),
//                                    spendingDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(spendingsResponse[i].spendingCreationTime)
//                                )
//                            )
//                        }
//                    }
