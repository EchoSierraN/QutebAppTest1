package com.gebeya.qutebapptest1.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.board.BottomNavBoard
import kotlinx.android.synthetic.main.activity_enter_verification.*

class EnterVerification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_verification)

        btn_enter_verification_reset_password.setOnClickListener {
            //reset password

            //move to the next activity
            startActivity(Intent(this, BottomNavBoard::class.java))
            finish()

        }
    }
}