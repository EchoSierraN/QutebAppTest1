package com.gebeya.qutebapptest1.board.fragments.entryCategories.entities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.BottomNavBoard
import com.gebeya.qutebapptest1.board.adapters.DashIncomeAdapter
import com.gebeya.qutebapptest1.board.fragments.entryCategories.IncomeCategoryActivity
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.model.IncomeModel
import com.gebeya.qutebapptest1.model.IncomeCategories
import kotlinx.android.synthetic.main.activity_income_transaction_entity.*
import java.util.*

class IncomeTransactionEntity : AppCompatActivity() {

    var incomeAmount: Double? = 0.0
    var incomeDate: String? = ""
    var incomeSource: String? = ""

    private var category = when (IncomeCategoryActivity.Companion.currentCategoryId) {
        0 -> IncomeCategories.DAY_JOB
        1 -> IncomeCategories.DIGITAL_ASSET_SALES
        2 -> IncomeCategories.CONTENT_CREATION
        else -> IncomeCategories.DAY_JOB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income_transaction_entity)

        //if there is data received to be edited, save it and set it to the editTexts
        val editEntryPosition = intent.extras?.getString(DashIncomeAdapter.EDIT_POSITION)

        incomeAmount = intent.extras?.getDouble(DashIncomeAdapter.EDIT_INCOME_AMOUNT)
        incomeDate = intent.extras?.getString(DashIncomeAdapter.EDIT_INCOME_DATE)
        incomeSource = intent.extras?.getString(DashIncomeAdapter.EDIT_INCOME_SOURCE)

        //set it to the editTexts
        et_income_amount.setText(incomeAmount.toString())
        et_income_reason.setText(incomeSource)

    }

    override fun onResume() {
        super.onResume()

        btn_income_add.setOnClickListener {
            verifyEntryInput(this@IncomeTransactionEntity.applicationContext)
        }
    }

    private fun verifyEntryInput(context: Context) {
        if (et_income_amount.text.toString() == "") {
            Toast.makeText(context, "Please enter transaction amount", Toast.LENGTH_SHORT)
                .show()
            return
        }

        //check if the entered data is a number
//        var numeric= true
//        try {
//            val num = Double.parseDouble(et_income_amount.text.toString())
//        } catch (e: NumberFormatException) {
//            numeric = false
//        }
//
//        if (numeric){
//            Toast.makeText(context, "Please enter a valid number for amount.", Toast.LENGTH_SHORT)
//                .show()
//            return
//        }

        if (et_income_reason.text.toString() == "") {
            Toast.makeText(context, "Please enter transaction reason", Toast.LENGTH_SHORT)
                .show()
            return
        }

        if (DashIncomeAdapter.editPosition != -1) {
            FinancialData.incomeData[DashIncomeAdapter.editPosition] =
                IncomeModel(
                    category,
                    et_income_reason.text.toString(),
                    et_income_amount.text.toString().toDouble(),
                    Date()
                )
            DashIncomeAdapter.editPosition = -1
        } else {
            FinancialData.incomeData.add(
                IncomeModel(
                    category,
                    et_income_reason.text.toString(),
                    et_income_amount.text.toString().toDouble(),
                    Date()
                )
            )
        }

        //startActivity(Intent(this, NoticeBoardActivity::class.java))
        startActivity(Intent(this, BottomNavBoard::class.java))
        finish()
    }
}