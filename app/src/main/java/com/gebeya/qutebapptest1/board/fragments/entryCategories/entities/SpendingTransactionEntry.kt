package com.gebeya.qutebapptest1.board.fragments.entryCategories.entities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.NoticeBoardActivity
import com.gebeya.qutebapptest1.board.fragments.entryCategories.SpendingCategoryActivity
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.model.SpendingModel
import com.gebeya.qutebapptest1.model.SpendingCategories
import kotlinx.android.synthetic.main.activity_spending_transaction_entry.*
import java.util.*

class SpendingTransactionEntry : AppCompatActivity() {
    private var category = when (SpendingCategoryActivity.Companion.currentCategoryId) {
        0 -> SpendingCategories.ENTERTAINMENT
        1 -> SpendingCategories.FAMILY_AND_PERSONAL
        2 -> SpendingCategories.FOOD
        else -> SpendingCategories.ENTERTAINMENT
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spending_transaction_entry)
    }

    override fun onResume() {
        super.onResume()

        btn_spending_add.setOnClickListener {
            verifyEntryInput(this@SpendingTransactionEntry.applicationContext)
        }
    }

    private fun verifyEntryInput(context: Context) {
        if (et_spending_amount.text.toString() == "") {
            Toast.makeText(context, "Please enter transaction amount", Toast.LENGTH_SHORT)
                .show()
            return
        }

        //check if the entered data is a number
//        var numeric= true
//        try {
//            val num = parseDouble(et_spending_amount.text.toString())
//        } catch (e: NumberFormatException) {
//            numeric = false
//        }
//
//        if (numeric){
//            Toast.makeText(context, "Please enter a valid number for amount.", Toast.LENGTH_SHORT)
//                .show()
//            return
//        }

        if (et_spending_reason.text.toString() == "") {
            Toast.makeText(context, "Please enter transaction reason", Toast.LENGTH_SHORT)
                .show()
            return
        }
        FinancialData.spendingData.add(
            SpendingModel(
                category,
                et_spending_reason.text.toString(),
                et_spending_amount.text.toString().toDouble(),
                Date().toString()
            )
        )
        startActivity(Intent(this, NoticeBoardActivity::class.java))
        finish()
    }
}