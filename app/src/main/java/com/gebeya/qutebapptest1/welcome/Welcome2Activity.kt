package com.gebeya.qutebapptest1.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.login.LoginActivity
import kotlinx.android.synthetic.main.activity_welcome1.*
import kotlinx.android.synthetic.main.activity_welcome2.*

class Welcome2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome2)

        //we don't want the action bar
        supportActionBar?.hide()

        tv_welcome2_we_got_you.setOnClickListener {
            startActivity(Intent(this, Welcome3Activity::class.java))
        }

        cl_welcome2_rootLayout.setOnClickListener {
            startActivity(Intent(this, Welcome3Activity::class.java))
        }

        tv_welcome2_skip.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}