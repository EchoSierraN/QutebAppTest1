package com.gebeya.qutebapptest1.board.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.fragments.entryCategories.SpendingCategoryActivity
import com.gebeya.qutebapptest1.board.fragments.entryCategories.entities.SpendingTransactionEntry
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.model.SpendingModel
import com.gebeya.qutebapptest1.model.SpendingCategories
import kotlinx.android.synthetic.main.layout_transaction_item.view.*

class DashSpendingAdapter(private var arrayList: ArrayList<SpendingModel>, context: Context) :
    RecyclerView.Adapter<DashSpendingAdapter.ViewHolder>() {
    var context= context
        companion object {
            var REQUEST_CODE_EDIT_TRANSACTION: Int = 0
            var editPosition: Int = -1

            var EDIT_POSITION= "editPosition"
            var EDIT_SPENDING_SOURCE= "editSpendingSource"
            var EDIT_SPENDING_DATE= "editSpendingDate"
            var EDIT_SPENDING_AMOUNT= "editSpendingAmount"
        }
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        fun bindItems(model: SpendingModel) {

            when (model.spendingCategory) {
                SpendingCategories.FAMILY_AND_PERSONAL -> itemView.iv_item.setImageResource(R.drawable.ic_baseline_account_circle_24)
                SpendingCategories.FOOD -> itemView.iv_item.setImageResource(R.drawable.ic_baseline_fastfood_24)
                SpendingCategories.ENTERTAINMENT -> itemView.iv_item.setImageResource(R.drawable.ic_baseline_games_24)
            }

            itemView.tv_item_amount.text = model.spendingAmount.toString()
            itemView.tv_item_source.text = model.spendingSource
            itemView.tv_item_date.text = model.spendingDate.toString()

            itemView.iv_transaction_menu.setOnClickListener {
                //show popup menu
                var popupMenu = PopupMenu(it.context, it)
                popupMenu.inflate(R.menu.menu_transaction)
                popupMenu.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.item_menu_edit -> {
                            //save the position
                            editPosition= arrayList.indexOf(model)
                            //startActivityForResult
                            val intentSpendingTransEntry= Intent(context, SpendingTransactionEntry::class.java)
                            intentSpendingTransEntry.putExtra(EDIT_SPENDING_SOURCE, model.spendingSource)
                            intentSpendingTransEntry.putExtra(EDIT_SPENDING_DATE, model.spendingDate)
                            intentSpendingTransEntry.putExtra(EDIT_SPENDING_AMOUNT, model.spendingAmount)
                            intentSpendingTransEntry.putExtra(EDIT_POSITION, arrayList.indexOf(model))

                            context.startActivity(intentSpendingTransEntry)

                            true
                        }

                        R.id.item_menu_delete -> {
                            //find the position of the menu.
                            var pos= arrayList.indexOf(model)
                            FinancialData.spendingData.removeAt(pos)
                            notifyItemRemoved(pos)
                            notifyItemRangeChanged(pos, FinancialData.spendingData.size)
                            itemView.visibility = View.GONE

                            true
                        }
                        else -> {
                            false
                        }
                    }
                }
                popupMenu.show()
            }
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
    }

}