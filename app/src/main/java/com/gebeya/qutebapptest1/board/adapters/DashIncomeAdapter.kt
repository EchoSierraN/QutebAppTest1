package com.gebeya.qutebapptest1.board.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.fragments.DashboardSpendingFragment
import com.gebeya.qutebapptest1.board.fragments.entryCategories.entities.IncomeTransactionEntity
import com.gebeya.qutebapptest1.board.fragments.entryCategories.entities.SpendingTransactionEntry
import com.gebeya.qutebapptest1.data.FinancialData
import com.gebeya.qutebapptest1.model.IncomeModel
import com.gebeya.qutebapptest1.model.IncomeCategories
import kotlinx.android.synthetic.main.layout_transaction_item.view.*

class DashIncomeAdapter(private var arrayList: ArrayList<IncomeModel>, context: Context) :
    RecyclerView.Adapter<DashIncomeAdapter.ViewHolder>() {
    val context= context
    companion object {
        var REQUEST_CODE_EDIT_TRANSACTION: Int = 0
        var editPosition: Int = -1

        var EDIT_POSITION= "editPosition"
        var EDIT_INCOME_SOURCE= "editIncomeSource"
        var EDIT_INCOME_DATE= "editIncomeDate"
        var EDIT_INCOME_AMOUNT= "editIncomeAmount"
    }
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        fun bindItems(model: IncomeModel) {
            when (model.incomeCategory) {
                IncomeCategories.DAY_JOB -> itemView.iv_item.setImageResource(R.drawable.ic_baseline_work_24)
                IncomeCategories.DIGITAL_ASSET_SALES -> itemView.iv_item.setImageResource(R.drawable.ic_baseline_computer_24)
                IncomeCategories.CONTENT_CREATION -> itemView.iv_item.setImageResource(R.drawable.ic_baseline_video_library_24)
            }
            itemView.tv_item_source.text = model.incomeSource
            itemView.tv_item_amount.text = DashboardSpendingFragment.formatMoney(model.incomeAmount)
            itemView.tv_item_date.text = model.incomeDate.toString()

            itemView.iv_transaction_menu.setOnClickListener {
                //show popup menu
                var popupMenu = PopupMenu(it.context, it)
                popupMenu.inflate(R.menu.menu_transaction)
                popupMenu.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.item_menu_edit -> {
                            //save the position
                            DashIncomeAdapter.editPosition = arrayList.indexOf(model)
                            //startActivity
                            val intentIncomeTransEntry =
                                Intent(context, IncomeTransactionEntity::class.java)
                            intentIncomeTransEntry.putExtra(
                                DashIncomeAdapter.EDIT_INCOME_SOURCE,
                                model.incomeSource
                            )
                            intentIncomeTransEntry.putExtra(
                                DashIncomeAdapter.EDIT_INCOME_DATE,
                                model.incomeDate
                            )
                            intentIncomeTransEntry.putExtra(
                                DashIncomeAdapter.EDIT_INCOME_AMOUNT,
                                model.incomeAmount
                            )
                            intentIncomeTransEntry.putExtra(
                                DashIncomeAdapter.EDIT_POSITION,
                                arrayList.indexOf(model)
                            )

                            context.startActivity(intentIncomeTransEntry)
                            true
                        }

                        R.id.item_menu_delete -> {
                            //find the position of the menu.
                            var pos = arrayList.indexOf(model)
                            FinancialData.incomeData.removeAt(pos)
                            notifyItemRemoved(pos)
                            notifyItemRangeChanged(pos, FinancialData.incomeData.size)
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


        holder.itemView.setOnClickListener {

        }
    }
}