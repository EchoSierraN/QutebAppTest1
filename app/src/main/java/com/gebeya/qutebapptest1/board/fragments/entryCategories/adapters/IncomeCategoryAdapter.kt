package com.gebeya.qutebapptest1.board.fragments.entryCategories.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.model.IncomeDataModel
import com.gebeya.qutebapptest1.model.IncomeModel
import com.gebeya.qutebapptest1.model.incomeCategories
import com.gebeya.qutebapptest1.model.spendingCategories
import kotlinx.android.synthetic.main.layout_category_item.view.*
import kotlinx.android.synthetic.main.layout_transaction_item.view.*


class IncomeCategoryAdapter(private var arrayList: ArrayList<IncomeDataModel>, context: Context) :
    RecyclerView.Adapter<IncomeCategoryAdapter.ViewHolder>() {
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        fun bindItems(model: IncomeDataModel) {
            itemView.iv_category.setImageResource(model.categoryImage)
            itemView.tv_category_source.text= model.categoryName
            itemView.tv_category_count.text= model.incomeCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_transaction_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {

        }
    }
}