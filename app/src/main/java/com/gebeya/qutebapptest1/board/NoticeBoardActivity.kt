package com.gebeya.qutebapptest1.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.adapters.ViewPagerAdapter
import com.gebeya.qutebapptest1.board.fragments.FavoritesFragment
import com.gebeya.qutebapptest1.board.fragments.HomeFragment
import com.gebeya.qutebapptest1.board.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_notice_board.*

class NoticeBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_board)

        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter= ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "")
        adapter.addFragment(FavoritesFragment(), "")
        adapter.addFragment(SettingsFragment(), "")

        viewPager.adapter= adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_favorite_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_settings_24)
    }
}