package com.gebeya.qutebapptest1.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.bottomNavBoard.DashboardFragment
import com.gebeya.qutebapptest1.board.bottomNavBoard.FeedbackFragment
import com.gebeya.qutebapptest1.board.bottomNavBoard.SpendingFragment
import com.gebeya.qutebapptest1.board.fragments.feedbacks.FeedbackMonthlySpendingFragment
import kotlinx.android.synthetic.main.activity_bottom_nav_board.*

class BottomNavBoard : AppCompatActivity() {

    private val dashboardFragment= DashboardFragment()
    //private val spendingFragment= SpendingFragment()
    //private val feedbackFragment= FeedbackFragment()
    private val feedbackMonthlySpendingFragment= FeedbackMonthlySpendingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_board)

        replaceFragment(dashboardFragment)

        nv_bottom_nav_board.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_Dashboard -> {
                    replaceFragment(dashboardFragment)
                }
                R.id.menu_Feedback -> replaceFragment(feedbackMonthlySpendingFragment)
                //R.id.menu_Spending -> replaceFragment(spendingFragment)
                //R.id.menu_Feedback -> replaceFragment(feedbackFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment!= null){
            val transaction= supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}