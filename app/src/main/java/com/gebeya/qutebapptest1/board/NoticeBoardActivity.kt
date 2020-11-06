package com.gebeya.qutebapptest1.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.adapters.ViewPagerAdapter
import com.gebeya.qutebapptest1.board.fragments.DashboardIncomeFragment
import com.gebeya.qutebapptest1.board.fragments.FavoritesFragment
import com.gebeya.qutebapptest1.board.fragments.DashboardSpendingFragment
import com.gebeya.qutebapptest1.board.fragments.SettingsFragment
import com.gebeya.qutebapptest1.board.fragments.feedbacks.FeedbackMonthlySpendingFragment
import kotlinx.android.synthetic.main.activity_notice_board.*

class NoticeBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_board)

        //setUpTabs()
    }

    private fun setUpTabs() {
        val adapter= ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(DashboardSpendingFragment(), "")
        adapter.addFragment(DashboardIncomeFragment(), "")
        adapter.addFragment(FeedbackMonthlySpendingFragment(), "")
        //adapter.addFragment(FavoritesFragment(), "")
        //adapter.addFragment(SettingsFragment(), "")

        dashboard_viewPager.adapter= adapter
        dashboard_tabs.setupWithViewPager(dashboard_viewPager)

        dashboard_tabs.getTabAt(0)!!.setIcon(R.drawable.ic_bar_chart)
        dashboard_tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_attach_money_24)
        dashboard_tabs.getTabAt(2)!!.setIcon(R.drawable.arrow_up)
    }
}