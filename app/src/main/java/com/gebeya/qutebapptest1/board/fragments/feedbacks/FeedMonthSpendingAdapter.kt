package com.gebeya.qutebapptest1.board.fragments.feedbacks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.model.FeedbackSpendingModel
import kotlinx.android.synthetic.main.feedback_spending_item.view.*


class FeedMonthSpendingAdapter(private var arrayList: ArrayList<FeedbackSpendingModel>, context: Context): RecyclerView.Adapter<FeedMonthSpendingAdapter.ViewHolder>(){
    inner class ViewHolder(listItemView: View): RecyclerView.ViewHolder(listItemView){
        fun bindItems(model: FeedbackSpendingModel){

//            when(model.spendingCategory){
//                spendingCategories.FAMILY_AND_PERSONAL-> itemView.iv_item.setImageResource(R.drawable.ic_baseline_account_circle_24)
//                spendingCategories.FOOD-> itemView.iv_item.setImageResource(R.drawable.ic_baseline_fastfood_24)
//                spendingCategories.ENTERTAINMENT-> itemView.iv_item.setImageResource(R.drawable.ic_baseline_games_24)
//            }

            itemView.iv_change.setImageResource(model.image)
            itemView.tv_month.text= model.month
            itemView.tv_feedback_summary.text= model.summary.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.feedback_spending_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }
}