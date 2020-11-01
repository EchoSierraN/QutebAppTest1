package com.gebeya.qutebapptest1.board.fragments.entryCategories.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.fragments.entryCategories.IncomeCategoryActivity
import com.gebeya.qutebapptest1.board.fragments.entryCategories.entities.IncomeTransactionEntity
import com.gebeya.qutebapptest1.board.fragments.entryCategories.entities.SpendingTransactionEntry
import com.gebeya.qutebapptest1.model.IncomeDataModel
import com.gebeya.qutebapptest1.model.IncomeModel
import com.gebeya.qutebapptest1.model.incomeCategories
import com.gebeya.qutebapptest1.model.spendingCategories
import kotlinx.android.synthetic.main.layout_category_item.view.*
import kotlinx.android.synthetic.main.layout_transaction_item.view.*


class IncomeCategoryAdapter(private var arrayList: ArrayList<IncomeDataModel>, context: Context) :
    RecyclerView.Adapter<IncomeCategoryAdapter.ViewHolder>() {
    private var context = context

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        fun bindItems(model: IncomeDataModel) {
            itemView.iv_category.setImageResource(model.categoryImage)
            itemView.tv_category_source.text = model.categoryName
            itemView.tv_category_count.text = model.incomeCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_category_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        var intentIncomeEntity = Intent(context, IncomeTransactionEntity::class.java)

        holder.itemView.setOnClickListener {
            when (position) {
                0 -> {
                    Toast.makeText(context, "DAY JOB CATEGORY", Toast.LENGTH_SHORT)
                        .show()
                    IncomeCategoryActivity.Companion.currentCategoryId = 0
                }

                1 -> {
                    Toast.makeText(context, "DIGITAL ASSET SALES CATEGORY", Toast.LENGTH_SHORT)
                        .show()
                    IncomeCategoryActivity.Companion.currentCategoryId = 1
                }

                2 -> {
                    Toast.makeText(context, "CONTENT CREATION CATEGORY", Toast.LENGTH_SHORT)
                        .show()
                    IncomeCategoryActivity.Companion.currentCategoryId = 2
                }
            }

            context.startActivity(intentIncomeEntity)
        }
    }
}