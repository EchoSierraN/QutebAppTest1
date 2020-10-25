package com.gebeya.qutebapptest1.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.login.LoginActivity
import kotlinx.android.synthetic.main.activity_welcome3.*

class Welcome3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome3)

        //we don't want the action bar
        supportActionBar?.hide()

        tv_welcome3_zero_fees.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}