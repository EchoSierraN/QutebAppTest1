package com.gebeya.qutebapptest1.board.fragments.entryCategories.entities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.NoticeBoardActivity
import com.gebeya.qutebapptest1.board.fragments.entryCategories.IncomeCategoryActivity
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.model.IncomeModel
import com.gebeya.qutebapptest1.model.incomeCategories
import kotlinx.android.synthetic.main.activity_income_transaction_entity.*
import java.lang.Double
import java.util.*

class IncomeTransactionEntity : AppCompatActivity() {
    private var category = when (IncomeCategoryActivity.Companion.currentCategoryId) {
        0 -> incomeCategories.DAY_JOB
        1 -> incomeCategories.DIGITAL_ASSET_SALES
        2 -> incomeCategories.CONTENT_CREATION
        else -> incomeCategories.DAY_JOB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income_transaction_entity)

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
        FinancialData.incomeData.add(
            IncomeModel(
                category,
                et_income_reason.text.toString(),
                et_income_amount.text.toString().toDouble(),
                Date().toString()
            )
        )
        startActivity(Intent(this, NoticeBoardActivity::class.java))
        finish()
    }
}