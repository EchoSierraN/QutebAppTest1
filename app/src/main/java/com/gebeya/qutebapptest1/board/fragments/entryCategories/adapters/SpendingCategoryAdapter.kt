package com.gebeya.qutebapptest1.board.fragments.entryCategories.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.fragments.entryCategories.SpendingCategoryActivity
import com.gebeya.qutebapptest1.board.fragments.entryCategories.entities.SpendingTransactionEntry
import com.gebeya.qutebapptest1.model.SpendingDataModel
import kotlinx.android.synthetic.main.layout_category_item.view.*
import kotlin.collections.ArrayList


class SpendingCategoryAdapter(
    private var arrayList: ArrayList<SpendingDataModel>,
    context: Context
) : RecyclerView.Adapter<SpendingCategoryAdapter.ViewHolder>() {
    private var context = context

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        fun bindItems(model: SpendingDataModel) {
            itemView.iv_category.setImageResource(model.categoryImage)
            itemView.tv_category_source.text = model.categoryName
            itemView.tv_category_count.text = model.spendingCount.toString()
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

        //prepare the intent to start activity
        var intentSpendingEntity = Intent(context, SpendingTransactionEntry::class.java)

        holder.itemView.setOnClickListener {
            when (position) {
                0 -> {
                    //id=0
                    Toast.makeText(context, "ENTERTAINMENT CATEGORY", Toast.LENGTH_SHORT)
                        .show()
                    SpendingCategoryActivity.Companion.currentCategoryId = 0
                }

                1 -> {
                    //id=1
                    Toast.makeText(context, "ENTERTAINMENT CATEGORY", Toast.LENGTH_SHORT)
                    SpendingCategoryActivity.Companion.currentCategoryId = 0
                }

                2 -> {
                    //id=2
                    Toast.makeText(context, "FOOD CATEGORY", Toast.LENGTH_SHORT)
                        .show()
                    SpendingCategoryActivity.Companion.currentCategoryId = 0
                }
            }
            context.startActivity(intentSpendingEntity)
        }
    }
}