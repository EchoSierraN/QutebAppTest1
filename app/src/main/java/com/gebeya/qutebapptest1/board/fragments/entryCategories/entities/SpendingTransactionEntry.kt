package com.gebeya.qutebapptest1.board.fragments.entryCategories.adapters

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.NoticeBoardActivity
import com.gebeya.qutebapptest1.board.fragments.DashboardSpendingFragment
import com.gebeya.qutebapptest1.board.fragments.entryCategories.SpendingCategoryActivity
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.model.SpendingModel
import com.gebeya.qutebapptest1.model.spendingCategories
import kotlinx.android.synthetic.main.activity_spending_transaction_entry.*
import kotlinx.android.synthetic.main.activity_spending_transaction_entry.view.*
import kotlinx.android.synthetic.main.layout_transaction_item.*
import java.util.*

class SpendingTransactionEntry : AppCompatActivity() {
    private var category = when (SpendingCategoryActivity.Companion.currentCategoryId) {
        0 -> spendingCategories.ENTERTAINMENT
        1 -> spendingCategories.FAMILY_AND_PERSONAL
        2 -> spendingCategories.FOOD
        else -> spendingCategories.ENTERTAINMENT
    }

    private lateinit var amount: String
    private lateinit var reason: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spending_transaction_entry)

//        amount= findViewById<EditText>(R.id.et_transaction_amount).toString().toDouble()
//        reason= findViewById<EditText>(R.id.et_transaction_amount).toString()
    }

    override fun onStart() {
        super.onStart()
        amount = et_transaction_amount.text.toString()
        reason = et_transaction_reason.text.toString()
    }

    override fun onResume() {
        super.onResume()

        btn_transaction_add.setOnClickListener {
            verifyEntryInput(this@SpendingTransactionEntry.applicationContext)
        }
    }

    private fun verifyEntryInput(context: Context) {
        if (et_transaction_amount.text.toString() == "") {
            Toast.makeText(context, "Please enter transaction amount", Toast.LENGTH_SHORT)
                .show()
            return
        }

        if (et_transaction_reason.text.toString() == "") {
            Toast.makeText(context, "Please enter transaction reason", Toast.LENGTH_SHORT)
                .show()
            return
        }
        FinancialData.spendingData.add(
            SpendingModel(
                category,
                et_transaction_reason.text.toString(),
                et_transaction_amount.text.toString().toDouble(),
                Date().toString()
            )
        )
        startActivity(Intent(this, NoticeBoardActivity::class.java))
        finish()
    }
}