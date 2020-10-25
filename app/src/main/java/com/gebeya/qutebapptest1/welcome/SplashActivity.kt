package com.gebeya.qutebapptest1.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.gebeya.qutebapptest1.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //we don't want the action bar
        supportActionBar?.hide()

        //three seconds after the splash screen opens, we want to move to the
        //welcome screens
        Handler().postDelayed({
            startActivity(Intent(this, Welcome1Activity::class.java))
            finish()
        }, 3000)

    }
}