package com.gebeya.qutebapptest1.board.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.fragments.DashboardSpendingFragment
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.model.SpendingModel
import com.gebeya.qutebapptest1.model.incomeCategories
import com.gebeya.qutebapptest1.model.spendingCategories
import kotlinx.android.synthetic.main.fragment_dashboard_spending.*
import kotlinx.android.synthetic.main.layout_transaction_item.view.*

class DashSpendingAdapter(private var arrayList: ArrayList<SpendingModel>, context: Context): RecyclerView.Adapter<DashSpendingAdapter.ViewHolder>(){
    inner class ViewHolder(listItemView: View): RecyclerView.ViewHolder(listItemView){
        fun bindItems(model: SpendingModel){

            when(model.spendingCategory){
                spendingCategories.FAMILY_AND_PERSONAL-> itemView.iv_item.setImageResource(R.drawable.ic_baseline_account_circle_24)
                spendingCategories.FOOD-> itemView.iv_item.setImageResource(R.drawable.ic_baseline_fastfood_24)
                spendingCategories.ENTERTAINMENT-> itemView.iv_item.setImageResource(R.drawable.ic_baseline_games_24)
            }

            itemView.tv_item_amount.text= model.spendingAmount.toString()
            itemView.tv_item_source.text= model.spendingSource
            itemView.tv_item_date.text= model.spendingDate.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.layout_transaction_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }
}