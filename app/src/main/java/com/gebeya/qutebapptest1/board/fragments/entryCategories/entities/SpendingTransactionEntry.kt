package com.gebeya.qutebapptest1.board.fragments.entryCategories.entities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.BottomNavBoard
import com.gebeya.qutebapptest1.board.NoticeBoardActivity
import com.gebeya.qutebapptest1.board.adapters.DashSpendingAdapter
import com.gebeya.qutebapptest1.board.fragments.entryCategories.SpendingCategoryActivity
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.model.SpendingModel
import com.gebeya.qutebapptest1.model.SpendingCategories
import kotlinx.android.synthetic.main.activity_spending_transaction_entry.*
import java.util.*

class SpendingTransactionEntry : AppCompatActivity() {

    var spendingAmount: Double? = 0.0
    var spendingDate: String? = ""
    var spendingSource: String? = ""

    private var category = when (SpendingCategoryActivity.currentCategoryId) {
        0 -> SpendingCategories.ENTERTAINMENT
        1 -> SpendingCategories.FAMILY_AND_PERSONAL
        2 -> SpendingCategories.FOOD
        else -> SpendingCategories.ENTERTAINMENT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spending_transaction_entry)

        //if there is data received to be edited, save it and set it to the editTexts
        val editEntryPosition = intent.extras?.getString(DashSpendingAdapter.EDIT_POSITION)

        spendingAmount = intent.extras?.getDouble(DashSpendingAdapter.EDIT_SPENDING_AMOUNT)
        spendingDate = intent.extras?.getString(DashSpendingAdapter.EDIT_SPENDING_DATE)
        spendingSource = intent.extras?.getString(DashSpendingAdapter.EDIT_SPENDING_SOURCE)

        //set it to the editTexts
        et_spending_amount.setText(spendingAmount.toString())
        et_spending_reason.setText(spendingSource)
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

        if (et_spending_reason.text.toString() == "") {
            Toast.makeText(context, "Please enter transaction reason", Toast.LENGTH_SHORT)
                .show()
            return
        }

        if (DashSpendingAdapter.editPosition != -1) {
            FinancialData.spendingData[DashSpendingAdapter.editPosition] =
                SpendingModel(
                    category,
                    et_spending_reason.text.toString(),
                    et_spending_amount.text.toString().toDouble(),
                    Date().toString()
                )
            DashSpendingAdapter.editPosition = -1
        } else {
            FinancialData.spendingData.add(
                SpendingModel(
                    category,
                    et_spending_reason.text.toString(),
                    et_spending_amount.text.toString().toDouble(),
                    Date().toString()
                )
            )
        }

        //startActivity(Intent(this, NoticeBoardActivity::class.java))
        startActivity(Intent(this, BottomNavBoard::class.java))
        finish()
    }
}