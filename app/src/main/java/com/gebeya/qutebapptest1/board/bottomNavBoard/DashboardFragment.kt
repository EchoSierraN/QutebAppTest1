package com.gebeya.qutebapptest1.board.bottomNavBoard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.adapters.ViewPagerAdapter
import com.gebeya.qutebapptest1.board.fragments.DashboardIncomeFragment
import com.gebeya.qutebapptest1.board.fragments.DashboardSpendingFragment
import com.gebeya.qutebapptest1.board.fragments.feedbacks.FeedbackMonthlySpendingFragment
import kotlinx.android.synthetic.main.activity_notice_board.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(this::class.java.simpleName, "OnCreate called.")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(this::class.java.simpleName, "OnCreateView called.")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onResume() {
        super.onResume()
        Log.d(this::class.java.simpleName, "OnResume called.")
        setupTabs()
    }

    private fun setupTabs() {
        adapter = ViewPagerAdapter(this.childFragmentManager!!)
        adapter.addFragment(DashboardSpendingFragment(), "")
        adapter.addFragment(DashboardIncomeFragment(), "")
        //adapter.addFragment(FeedbackMonthlySpendingFragment(), "")

        vp_dashboard.adapter = adapter
        vp_dashboard.setCurrentItem(0, true)
    }

}