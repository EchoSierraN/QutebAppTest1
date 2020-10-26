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
import com.gebeya.qutebapptest1.model.IncomeModel
import com.gebeya.qutebapptest1.model.incomeCategories
import kotlinx.android.synthetic.main.fragment_dashboard_spending.*
import kotlinx.android.synthetic.main.layout_transaction_item.view.*

class DashIncomeAdapter(private var arrayList: ArrayList<IncomeModel>, context: Context): RecyclerView.Adapter<DashIncomeAdapter.ViewHolder>(){
    inner class ViewHolder(listItemView: View): RecyclerView.ViewHolder(listItemView){
        fun bindItems(model: IncomeModel){
            when(model.incomeCategory){
                incomeCategories.DAY_JOB-> itemView.iv_item.setImageResource(R.drawable.ic_baseline_work_24)
                incomeCategories.DIGITAL_ASSET_SALES-> itemView.iv_item.setImageResource(R.drawable.ic_baseline_computer_24)
                incomeCategories.CONTENT_CREATION-> itemView.iv_item.setImageResource(R.drawable.ic_baseline_video_library_24)
            }
            itemView.tv_item_source.text= model.incomeSource
            itemView.tv_item_amount.text= model.incomeAmount.toString()
            itemView.tv_item_date.text= model.incomeDate.toString()
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


        holder.itemView.setOnClickListener {

        }
    }
}