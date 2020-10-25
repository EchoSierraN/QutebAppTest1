package com.gebeya.qutebapptest1.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.gebeya.qutebapptest1.R
import kotlinx.android.synthetic.main.activity_notice_board.*

class NoticeBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_board)

        //we don't want the action bar
        supportActionBar?.hide()
    }
}