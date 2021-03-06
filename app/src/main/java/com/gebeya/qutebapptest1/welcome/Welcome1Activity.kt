package com.gebeya.qutebapptest1.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gebeya.qutebapptest1.R
import kotlinx.android.synthetic.main.activity_welcome1.*

class Welcome1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome1)

        //we don't want the action bar
        supportActionBar?.hide()

        tv_welcome1_welcome.setOnClickListener {
            startActivity(Intent(this, Welcome2Activity::class.java))
        }
    }
}